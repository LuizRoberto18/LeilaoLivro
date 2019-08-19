import static com.jayway.restassured.RestAsssured.*;
import static com.jayway.restassured.matcher.RestassuredMatchers.*;
import com.mycompany.leilao.Usuario;
import java.util.List;
import static javax.swing.UIManager.get;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UsuariosWSTest {
    @Test 
    public void deveRetornarUmalistaDeUsuarios(){
        JasonPath path = given()
                .header("Accept", "application/xml")
                .get("/usuarios")
                .andReturn().JsonPath();
        
        List<Usuario> usuarios = path
                .getList("list.usuario", Usuario.class);
        
        
        Usuario esperado1 = new Usuario(1L, "Mauricio Aniche", "mauricio.anich@caelum.com.br");
        Usuario esperado2 = new Usuario(2L, "guilherme Silveira", "guilherme.silveira@caelum.com.br");
        
        assertEquals(esperado1, usuarios.get(0));
        assertEquals(esperado2, usuarios.get(1));
    } 
    @Test
    public void deveRetornarUsuarioPeloId(){
        Jason path = given()
                .parameter("usuario.id",1)
                .header("Acecept", "application/jason")
                .get("/usuarios/show")
                .andReturn.json();
        Usuario usuario = path.getObject("usuario", Usuario.class);
        Usuario esperado = new Usuario(1L, "Mauricio Aniche", "mauricio.aniche@caelum.com.br");
        assertEquals(esperado, usuario);
    }
    
    @Test
    public void deveAdicionarUmUsuariio(){
        Usuario joao = new Usuario("joao da Silva", "joao@dasilva.com.br");
        XmlPath retorno =    
            given()
                .header("Accept", "application/xml")
                .contentType("application/xml")
                .body(joao);
            .expect()
                .statusCode(200)    
            .when()
                .post("/usuarios")
            .andReturn()
                .xmlPath();
        Usuario resposta = retorno.getObject("usuario", Usuario.class);
        assertEquals("joao da Silva", resposta.getNome());
        assetEquals("joao@dasilva", resposta.getEmail());
    }
    
    @Test
    public void deveGerarUmCookie(){
        expect()
                .cookie("rest-assured", "funciona");
        .when()
                .get("/cookie/teste");
    }
    @Test
    public void deeveGerarUmCookie(){
        expect()
            .header("novo-header", "abc")
        .when()
                .get("/cookie/teste");
    }
}
