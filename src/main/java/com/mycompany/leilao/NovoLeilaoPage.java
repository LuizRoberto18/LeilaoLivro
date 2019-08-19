package com.mycompany.leilao;
public class NovoLeilaoPage {
    private WebDriver driver;
    
    public NovoLeilaoPage(WebDriver driver){
        this.driver = driver;
    }
    
    public void preenche(String nome, double valor, String usuario, boolean usado){
        WebElement txtNome = driver.findElemnent(By.name("leilao.nome"));
        WebElement txtValor = driver.findElemnent(By.name("leilao.valorInicial"));
          
        txtNome.sendKeys(nome);
        txtValor.sendKeys(String.valueOf(valor));
          
        WebElement combo = driver.findElemnent(By.name("leilao.usuario.id"));
        Select cbUsuario = new Select(combo);
        cbUsuario.selectByVisibleText(usuario);
        
        if(usado){
           WebElement ckUsado = driver.findElemnent(By.name("leilao.usado"));
           ckUsado.click();
        }
        txtNome.submit();
    }
}
