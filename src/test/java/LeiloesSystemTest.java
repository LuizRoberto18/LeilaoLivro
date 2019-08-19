
import com.mycompany.leilao.LeiloesPage;
import com.mycompany.leilao.NovoLeilaoPage;
import com.mycompany.leilao.UsuariosPage;
import org.junit.Before;
import org.junit.Test;

public class LeiloesSystemTest {
    private WebDriver driver;
    private LeiloesPage leiloes;
    
    @Before
    public void inicializar(){
        this.driver = new FirefoxDriver();
        leiloes = new LeiloesPage(driver);
        UsuariosPage usuarios = new UsuariosPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra(
        "Paulo henrique",
        "paulo@henrique.com");
    }
    
    @Test
    public void deveCadastrarUmLeilao(){
        leiloes.visita();
        NovoLeilaoPage novoLeilao = leiloes.novo();
        novoLeilao.preenche("Geladeira", 123, "Paulo henrique", true);
        leiloes.existe("Geladeira", 123, "Paulo henrique", true);
    }
    
    @Test
    public void deveFazerUmLance(){
        leiloes.detalhes(1);
        
        lances.lance("José Alberto", 150);
        
        assertTrue(lances.existeLance("José Alberto"));
    }
}
