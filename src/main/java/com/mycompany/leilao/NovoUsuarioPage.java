package com.mycompany.leilao;
public class NovoUsuarioPage {
     
    private WebDriver driver;
    
    public NovoUsuarioPage(WebDriver driver){
        this.driver = driver;
    }
    public void cadastrar(String nome, String email){
        WebElement txtNome = driver.findElement(By.name("usuario.nome"));
        WebElement txtEmail = driver.findElement(By.name("usuario.email"));
        
        txtNome.sendKeys(nome);
        txtEmail.sendKeys(email);
        
        txtNome.submit();
    }
    
    
}
