

import java.util.Calendar;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import edu.ifal.br.criador.CriadorDeLeilao;
import edu.ifal.br.dao.LeilaoDao;
import edu.ifal.br.dao.UsuarioDao;
import edu.ifal.br.modelo.Leilao;
import edu.ifal.br.modelo.Session;
import edu.ifal.br.modelo.Usuario;

public class LeilaoDaotests {
    
    private Session session;
    private LeilaoDao leilaoDao;
    private UsuarioDao usuarioDao;
    
    @Before
    public void antes(){
        session = new CriadorDeLeilao().getSession();
        leilaoDao = new LeilaoDao(session);
        usuarioDao = new UsuarioDao(session);
        
        session.beginTransaction();
    }
    @After
    public void depois(){
        session.getTransaction().rollback();
        session.close();
    }
    
    @Test
    public void deveConterLeiloesNaoEncerrados(){
        Usuario mauricio = new Usuario("Mauricio aniche", "mauricio@aniche.com");
        
        Leilao ativo = new  Leilao("geladeira", 1500.0, mauricio, false);
        Leilao encerrado = new  Leilao("XBox", 700.0, mauricio, false);
        encerrado.encerra();
        
        usuarioDao.salvar(mauricio);
        leilaoDao.salvar(ativo);
        leilaoDao.salvar(encerrado);
        
        long total = leilaoDao.total();
        
        assertEquals(1L, total);
    }  
    
    @Test
    public void deveTrazerLeiloesNaoEncerradosNoPeriodo(){
        
        Calendar comecoDoIntervalo = Calendar.getInstance();
        comecoDoIntervalo.add(Calendar.DAY_OF_MONTH, -10);
        Calendar FimDoIntervalo = Calendar.getInstance();

        Calendar dataDoLeilao1 = Calendar.getInstance();
        dataDoLeilao1.add(Calendar.DAY_OF_MONTH, -2);
       
        Calendar dataDoLeilao2 = Calendar.getInstance();
        dataDoLeilao2.add(Calendar.DAY_OF_MONTH, -20);
        
        Usuario mauricio = new Usuario("mauricio aniche", "mauricio@aniche.com.br");
        
        Leilao leilao1 = new  Leilao("XBox", 700.0, mauricio, false);
        leilao1.setDataAbertura(dataDoLeilao1);
        Leilao leilao2 = new  Leilao("geladeira", 1500.0, mauricio, false);
        leilao2.setDataAbertura(dataDoLeilao2);
        
        usuarioDao.salvar(mauricio);
        leilaoDao.salvar(leilao1);
        leilaoDao.salvar(leilao2);
        
        List<Leilao> leiloes = leilaoDao.porPeriodo(comecoDoIntervalo, FimDoIntervalo);
        
        assertEquals(1, leiloes.size());
        assertEquals("Xbox", leiloes.get(0).getNome());
    }
    
    @Test
    public void naodeveTrazerLeiloesEncerradosNoPeriodo(){
        
        Calendar comecoDoIntervalo = Calendar.getInstance();
        comecoDoIntervalo.add(Calendar.DAY_OF_MONTH, -10);
        Calendar FimDoIntervalo = Calendar.getInstance();

        Calendar dataDoLeilao1 = Calendar.getInstance();
        dataDoLeilao1.add(Calendar.DAY_OF_MONTH, -2);
       
        Usuario mauricio = new Usuario("mauricio aniche", "mauricio@aniche.com.br");
        
        Leilao leilao1 = new  Leilao("XBox", 700.0, mauricio, false);
        leilao1.setDataAbertura(dataDoLeilao1);
        leilao1.encerra();
        usuarioDao.salvar(mauricio);
        leilaoDao.salvar(leilao1);
        
        List<Leilao> leiloes = leilaoDao.porPeriodo(comecoDoIntervalo, FimDoIntervalo);
        
        assertEquals(0, leiloes.size());
    }
}
