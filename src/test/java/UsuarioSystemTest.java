
import com.mycompany.leilao.UsuariosPage;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class UsuarioSystemTest {
    
    private WebDrive driver;
    private UsuariosPage usuarios;
    
    @Before
    public void inicializar(){
        driver = new FireFoxDriver();
        this.usuarios = new UsuariosPage(driver);
    }
        
    @Test 
    public void deeveAdicionarUmUsuario(){
        
        usuarios.visitar();
        usuarios.novo().cadastrar(
                "Ronaldo luiz de alburquerque",
                "ronaldo2000@terra.com.br"
        );
     
        assertTrue(usuarios.existeNaListagem("Ronaldo luiz de alburquerque", "ronaldo2000@terra.com.br"));
        
    }
    @After
    public void encerra(){
        driver.close();
    }
}
