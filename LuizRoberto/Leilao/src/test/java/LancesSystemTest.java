
import com.mycompany.leilao.CriadorDeCenarios;
import com.mycompany.leilao.DetalhesDoLeilaoPage;
import com.mycompany.leilao.LeiloesPage;
import com.mycompany.leilao.UsuariosPage;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LancesSystemTest {
    private WebDriver driver;
    private LeiloesPage leiloes;
    
    @Before
    public void criaCenario(){
        lances = new DetalhesDoLeilaoPge(driver);
        
        new CriadorDeCenarios(driver)
                .umUsuario("Paulo henrique","paulo@henrique.com")
                .umUsuario("Jose Alberto", "jose@alberto.com")
                .umLeilao("Paulo henrique", "geladeira", 100, false);
    }
    
    @Test
    public void deveFazerUmLance(){
        DetalhesDoLeilaoPage lances = leiloes.detalhes(1);
        lances.lance("Jose Alberto", 150);
        assertTrue(lances.existeLance("Jose Alberto", 150));
    }
    
}
