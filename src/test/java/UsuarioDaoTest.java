
import com.mycompany.leilao.Session;
import com.mycompany.leilao.Usuario;
import com.mycompany.leilao.UsuarioDao;
import javax.management.Query;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.mockito.Mockito;

public class UsuarioDaoTest {
    
    @Test
    public void deveEncontrarPeloNomeEEmailMockado(){
        Session session = new CriadordeSessao().getSession();
        Query query = Mockito.mock(Query.class);
        UsuarioDao usuarioDao = new UsuarioDao(session);
        
        //criando usuario e saalvando antesde invocar o porNmeEEmail
        Usuario novoUsuario = new Usuario("Joao da silva", "joao@dasilva.com.br");
        usuarioDao.salvar(novoUsuario);
        
        //agora buscando no Banco de dados
        Usuario usuarioDoBanco = usuarioDao.porNomeEEmail("Joao da silva", "joao@dasilva.com.br");
        
        assertEquals("joao da silva", usuarioDoBanco.getNome());
        assertEquals("joao@dasilva.com.br", usuarioDoBanco.getEmail());
        session.close();
           
    }
    
    @Test
    public void deveDeletarUmUsuario(){
        
        Usuario usuario = new Usuario("mauricio aniche", "mauricio@aniche.com.br");
        
        UsuarioDao usuarioDao;
		usuarioDao.salvar(usuario);
        usuarioDao.deletar(usuario);
        
        Session.flush();
        
        Usuario usuarioNoBanco = usuarioDao.porNomeEEmail("mauricio aniche", "mauricio@aniche.com.br");
        
        assertNull(usuarioNoBanco);
    
    }
    
}
