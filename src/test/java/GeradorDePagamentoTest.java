
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import edu.ifal.br.criador.CriadorDeLeilao;
import edu.ifal.br.interfaces.Relogio;
import edu.ifal.br.modelo.Avaliador;
import edu.ifal.br.modelo.GeradorDePagamento;
import edu.ifal.br.modelo.Leilao;
import edu.ifal.br.modelo.Pagamento;
import edu.ifal.br.modelo.Usuario;
import edu.ifal.br.repositorios.RepositorioDeLeiloes;
import edu.ifal.br.repositorios.RepositorioDePagamentos;

public class GeradorDePagamentoTest {
    
    private Relogio relogio;

	@Test
    public void deveGerarPagamentoParaUmLeilaoEncerrado(){
        
        RepositorioDeLeiloes leiloes = mock(RepositorioDeLeiloes.class);
        RepositorioDePagamentos pagamentos = mock(RepositorioDePagamentos.class);
        Avaliador avaliador = mock(Avaliador.class);
        
        Leilao leilao = new CriadorDeLeilao().para("Playstition")
                .lance(new Usuario("Jose da silva"), 2000.0)
                .lance(new Usuario("Maria perreira"), 2500.0)
                .constroi();
        when(leiloes.encerrados())
                .thenReturn(Arrays.asList(leilao));
        when(avaliador.getMaiorLance())
                .thenReturn(2500.0);
        
        GeradorDePagamento gerador = new GeradorDePagamento(leiloes, 
                pagamentos,avaliador);
        gerador.gerar();
        
        ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
        
        verify(pagamentos).salvar(argumento.capture());
    
        Pagamento pagamentoGerado = argumento.getValue();
        assertEquals(2500.0, pagamentoGerado.getValor(), 0.00001);
    }
    
    private RepositorioDeLeiloes mock(Class<RepositorioDeLeiloes> class1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
    public  void deveEmpurrarParaProximoDiaUtil(){
        RepositorioDeLeiloes leiloes = mock(RepositorioDeLeiloes.class);
        RepositorioDePagamentos pagamentos = mock(RepositorioDePagamentos.class);
        
        Calendar sabado = Calendar.getInstance();
        sabado.set(2012, Calendar.APRIL, 7);
        
        when(relogio.hoje().thenReturn(sabado));
         Leilao leilao = new CriadorDeLeilao()
                .para("Playstition")
                .lance(new Usuario("Jose da silva"), 2000.0)
                .lance(new Usuario("Maria perreira"), 2500.0)
                .constroi();
         
         when(leiloes.encerrados())
           .thenReturn(Arrays.asList(leilao));
         
         GeradorDePagamento gerador = new GeradorDePagamento(leiloes, 
                pagamentos,new Avaliador(), relogio);
        gerador.gerar();
            
        ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
           verify(pagamentos).salvar(argumento.capture());
           Pagamento pagamentoGerado = argumento.getValue();
           
        assertEquals(Calendar.MONDAY, pagamentoGerado.getData().get(Calendar.DAY_OF_WEEK));
        assertEquals(9, pagamentoGerado.getData().get(Calendar.DAY_OF_MONTH));   
    }

	private Object when(List<Leilao> encerrados) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object verify(RepositorioDePagamentos pagamentos) {
		// TODO Auto-generated method stub
		return null;
	}
}
