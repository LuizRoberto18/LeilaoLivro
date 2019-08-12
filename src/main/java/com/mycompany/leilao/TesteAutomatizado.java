package com.mycompany.leilao;

public class TesteAutomatizado {
    public static void main(String [] args){
        
        WebDriver driver = new FireFoxDriver();
        
        driver.get("http://www.google.com.br/");
        
        WebElement campoDeTexto = 
                driver.findElement(By.name("q"));
        campoDeTexto.sendKeys("Caelum");
        campoDeTexto.submit();
    }
}
