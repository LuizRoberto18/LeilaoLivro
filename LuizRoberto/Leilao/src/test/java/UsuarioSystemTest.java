
import com.mycompany.leilao.UsuariosPage;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuarioSystemTest {
    
    private WebDriver driver;
    private UsuariosPage usuarios;
    
    @Before
    public void inicializar(){
        driver = new FirefoxDriver();
        this.usuarios = new UsuariosPage(driver);
    }
        
    @Test 
    public void deeveAdicionarUmUsuario(){
        
        usuarios.visita();
        usuarios.novo().cadastra(
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
