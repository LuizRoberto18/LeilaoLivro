
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

import edu.ifal.br.dao.UsuarioDao;
import edu.ifal.br.modelo.Session;
import edu.ifal.br.modelo.Usuario;

public class UsuarioDaoTests {
    
    private Session session;
    private UsuarioDao usuarioDao;
    
    @Before
    public void antes(){
        session = new CriadorDeSesssao().getSession();
        usuarioDao = new UsuarioDao(session);
        
    }
     @After
    public void depois(){
        session.close();
    }
    @Test
    public void deveEncontrarPeloNomeEEmail(){
        Usuario novoUsuario = new Usuario("joao da Silva ", "joao@dasilva.com.br");
        usuarioDao.salvar(novoUsuario);
        
        Usuario usuarioDoBanco =usuarioDao.porNomeEEmail("joao da Silva ", "joao@dasilva.com.br");
        
        assertEquals("joao da Silva ", usuarioDoBanco.getNome());
        assertEquals("joao@dasilva.com.br", usuarioDoBanco.getEmail());
    }
    
    @Test
    public void deveRetornarNuloSeNaoEncontrarUsuario(){
        Usuario usuarioDoBanco = usuarioDao.porNomeEEmail("joao da Silva ", "joao@dasilva.com.br");
        assertNull(usuarioDoBanco);
    }




}



