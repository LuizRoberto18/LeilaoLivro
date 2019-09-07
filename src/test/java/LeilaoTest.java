import static org.junit.Assert.assertEquals;
import org.junit.Test;

import edu.ifal.br.modelo.Lance;
import edu.ifal.br.modelo.Leilao;
import edu.ifal.br.modelo.Usuario;

public class LeilaoTest {
    
    private int ultimo;

	@Test
    public void deveReceberUmLance(){
        Leilao leilao = new Leilao("Macbook pro 15");
        assertEquals(0, leilao.getLances().size());
     
        leilao.propoe(new Lance(new Usuario("Steve jobs"), 2000.0));
     
        assertEquals(1, leilao.getLances().size());
        assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
    }
    
    @Test
    public void deveReceberVariosLances(){
        Leilao leilao = new Leilao("Macbook pro 15");
        
        leilao.propoe(new Lance(new Usuario("Steve jobs"), 2000.0));
        leilao.propoe(new Lance(new Usuario("Steve Wozniak"), 3000.0));
        
        assertEquals(2, leilao.getLances().size());
        assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
        assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
    }
    
    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario(){
        Leilao leilao = new Leilao("Macbook pro 15");
        Usuario steveJobs = new Usuario("Steve jobs");
        
        leilao.propoe(new Lance(steveJobs, 2000));
        leilao.propoe(new Lance(steveJobs, 2000));
  
        assertEquals(1, leilao.getLances().size());
        assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
        
    }
    
    @Test
    public void naoDeveAceitarMaisQue5lancesDeUmMesmoUsuario(){
        Leilao leilao = new Leilao("Macbook pro 15");
        Usuario steveJobs = new Usuario("Steve jobs");
        Usuario billGates = new Usuario("Bill Gates");
        
        leilao.propoe(new Lance(steveJobs, 2000));
        leilao.propoe(new Lance(billGates, 3000));
        leilao.propoe(new Lance(steveJobs, 4000));
        leilao.propoe(new Lance(billGates, 5000));
        leilao.propoe(new Lance(steveJobs, 6000));
        leilao.propoe(new Lance(billGates, 7000));
        leilao.propoe(new Lance(steveJobs, 8000));
        leilao.propoe(new Lance(billGates, 9000));
        leilao.propoe(new Lance(steveJobs, 10000));
        leilao.propoe(new Lance(billGates, 11000));
       
        //deve Ser ignorado
        leilao.propoe(new Lance(steveJobs, 10000));

        assertEquals(10, leilao.getLances().size());
        Lance ultimoLance = leilao.getLances().get(ultimo);
        
        assertEquals(11000.0, ultimoLance.getValor(), 0.00001);
    }
}








