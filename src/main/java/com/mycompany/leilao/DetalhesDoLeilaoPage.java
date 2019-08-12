package com.mycompany.leilao;

import com.sun.org.apache.bcel.internal.generic.Select;

public class DetalhesDoLeilaoPage {
    private WebDriver driver;
    
    public DetalhesDoLeilaoPage(WebDriver driver){
        this.driver = driver;
    }
    public void lance(String usuario, double valor){
        WebElement txtValor = driver.findElemnent(By.name("lance.valor"));
        WebElement combo = driver.findElemnent(By.name("lance.usuario.id"));
        Select cbUsuario = new Select(combo);
        
        cbUsuario.selectByVisibleText(usuario);
        txtValor.sendKeys(String.valueOf(valor));
        driver.findElement(By.id("btnDarLance")).click();
    }
    
    public boolean existeLance(String usuario, double valor){
       
        Boolean temUsuario = new WebDriverWait(driver, 10)
                                    .until(ExpectedConditions)
                                    .textToBePresentInElement(
                                       By.id("lancesDados"), usuario);
        if(temUsuario) return driver.getPageSouce().contains(String.valueOf(valor));
        return false;
    }
    
}
