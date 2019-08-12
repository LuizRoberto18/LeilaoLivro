
import com.mycompany.leilao.CriadorDeLeilao;
import com.mycompany.leilao.EncerradorDeLeilao;
import com.mycompany.leilao.Leilao;
import com.mycompany.leilao.LeilaoDaoFalso;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class EncerradorDeLeilaoTest {
    
    @Test
    public void deveEncerrarLeiloesQueComecaramUmaSemanaAtras(){
        Calendar antiga = Calendar.getInstance();
        antiga.set(1999, 1, 20);
        
        Leilao leilao1 = new CriadorDeLeilao().para("TV de lasma")
                .naData(antiga).constroi();
        Leilao leilao2 = new CriadorDeLeilao().para("Geladeira")
                .naData(antiga).constroi();
       
        List<Leilao> leiloesAntigos = new Arrays.asList(leilao1, leilao2);
       
        LeilaoDao daoFalso = mock(leilaoDao.class);
        
        when(daoFalso.correntes()).thenReturn(leiloesAntigos);
                
        EncerradorDeLeilao encerrador = new EncerradorDeLeilao();
        encerrador.encerra();
        
        assertTrue(leilao1.isEncerrado());
        assertTrue(leilao2.isEncerrado());
        assertEquals(2, encerrador.getQuantidadeDeEncerrados());

    }
    
    @Test
    public void deveAtualizarLeiloesEncerrados(){
        Calendar antiga = new Calendar.getInstance();
        antiga.set(1999, 1, 20);
        
        Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma").naData(antiga).constroi();
        
        RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
        when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1));
        
        EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso);
        encerrador.encerra();
        //verificando que o metodo atualiza foi realmente invocado 
        verify(daoFalso, times(1)).atualiza(leilao1);
    }
    
    @Test
    public void deveContinuarAExecucaoMesmoQuandoDaoFalha(){
         Calendar antiga = Calendar.getInstance();
        antiga.set(1999, 1, 20);
        
        Leilao leilao1 = new CriadorDeLeilao().para("TV de lasma")
                .naData(antiga).constroi();
        Leilao leilao2 = new CriadorDeLeilao().para("Geladeira")
                .naData(antiga).constroi();
        
         RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
        when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1));
        
        doThrow(new RuntimeException()).when(daoFalso).atualiza(leilao1);
        
        EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
        EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso, carteiroFalso);
        encerrador.encerra();
        verify(daoFalso).atualiza(leilao2);
        verify(carteiroFalso).envia(leilao2);
    }
    
}
