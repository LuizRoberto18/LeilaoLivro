package com.mycompany.leilao;
public class UsuariosPage {
    
    private WebDriver driver;
    
    public UsuariosPage(WebDriver driver){
        this.driver = driver;
    }
    
    public void visita(){
        driver.get("localhost:8080/usuarios");
    }
    
    public void novo(){
        //clica no link de novo usuario
        driver.findElement(By.linkText("Novo Usuario"))
                .click();
    }
    public boolean existeNaListagem(String nome, String email){
        return driver.getPageSoucer().contains(nome) 
                &&
                driver.getPageSoucer().contains(email);
       
    }
}
