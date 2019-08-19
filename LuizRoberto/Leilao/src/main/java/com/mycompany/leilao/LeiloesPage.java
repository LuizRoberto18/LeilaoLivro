package com.mycompany.leilao;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage {
        private WebDriver driver;
    
    public LeiloesPage(WebDriver driver){
        this.driver = driver;
    }
    public void visita(){
        driver.get("http://localhost:8080/leiloes");
    }
    public NovoLeilaoPage novo(){
        //clica no link do proximo leilao
        driver.findElement(By.linkText("Novo Leilao")).click();
        //retorna a classe que representa a nova pagina
        return new NovoLeilaoPage(driver);
    }
    public boolean existe(String produto, double valor, String usario, boolean usado){
        return driver.getPageSource().contains(produto) &&
                driver.getPageSource().contains(String.valueOf(valor))&&
                driver.getPageSource().contains(usado ? "sim" : "não");
    }
    public DetalhesDoLeilaoPage detalhes(int posicao){
        List<WebElement> elementos = 
                driver.findElements(By.linkText("Exibir"));
        elementos.get(posicao - 1).click();
        return new DetalhesDoLeilaoPage(driver);
    }
}
