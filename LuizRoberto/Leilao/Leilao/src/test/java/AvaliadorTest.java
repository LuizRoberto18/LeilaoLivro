

import com.mycompany.leilao.Avaliador;
import com.mycompany.leilao.CriadorDeLeilao;
import com.mycompany.leilao.Lance;
import com.mycompany.leilao.Leilao;
import com.mycompany.leilao.Usuario;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class AvaliadorTest {
    private Avaliador leiloeiro;
    private Usuario joao;
    private Usuario jose;
    private Usuario maria;
    
    @Before
    private void criaAvaliador(){
        this.leiloeiro = new Avaliador();
        this.joao = new Usuario("Joao");
        this.jose = new Usuario("Jose");
        this.maria = new Usuario("Maria");
    }
    @Test
    public void deveEntenderLancesEmOrdemCrescentte() {

        Leilao leilao = new CriadorDeLeilao()
            .para("Playstation 3 Novo")
            .lance(joao, 250.0)
            .lance(jose, 300.0)
            .lance(maria, 400.0)
            .constroi();

        leiloeiro.avaliar(leilao);


        assertThat(leiloeiro.getMaiorLance(), equalTo(250.0));
        assertThat(leiloeiro.getMenorLance(), equalTo(400.0));
    }

    @Test
    public void deveEntenderLancesEmOrdemCrescentteComOutrosValores() {
        
        Leilao leilao = new Leilao("Playstationn 3 Novo");

        leilao.propoe(new Lance(maria, 1000.0));
        leilao.propoe(new Lance(joao, 2000.0));
        leilao.propoe(new Lance(jose, 3000.0));
        
        criaAvaliador();
        leiloeiro.avaliar(leilao);

        assertEquals(3000.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
    }

    @Test
    public void deveEntenderLeilaoComApenasUmLance() {

        Leilao leilao = new Leilao("Playstationn 3 Novo");

        leilao.propoe(new Lance(joao, 1000.0));
        
        criaAvaliador();
        leiloeiro.avaliar(leilao);

        assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);

    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {

        Leilao leilao = new CriadorDeLeilao()
                .para("Playstition 3 Novo")
                .lance(joao, 100.0)
                .lance(maria, 200.0)
                .lance(joao, 300.0)
                .lance(maria, 400.0)
                .constroi();
     
        leiloeiro.avaliar(leilao);
        
        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
    }
    
    @Test(expected=RuntimeException.class)
    public void naoDeveAvaliarLeiloesSemNenhumLanceDado(){
        try{
            Leilao leilao = new CriadorDeLeilao()
                .para("Playstition 3 Novvo ")
                .constroi();
            leiloeiro.avaliar(leilao);
            Assert.fail();
        }
        catch(RuntimeException e){
            //Deu certo!
        }
    }
    
}
