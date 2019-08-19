package com.mycompany.leilao;

import org.openqa.selenium.WebDriver;

abstract class PageObject {
    protected WebDriver driver;
    
    public PageObject(WebDriver driver){
        this.driver = driver;
    }
    
    public abstract String url();
    
    public void visita(){
        driver.get( url() );
    }
}
