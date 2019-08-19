package com.mycompany.leilao;

import java.util.ArrayList;
import java.util.List;

public class LeilaoDaoFalso {
    
    private static List<Leilao> leiloes = new ArrayList<Leilao>();
    
    public void salvar(Leilao leilao){
        leiloes.add(leilao);
    }
    
    public  List<Leilao> encerrados(){
        List<Leilao> filtrados = new ArrayList<Leilao>();
        for(Leilao leilao : leiloes){
            if(!leilao.iSEncerrado()) filtrados.add(leilao);
        }
        return filtrados;
    }
    
    public List<Leilao> correntes(){
        List<Leilao> filtrados = new ArrayList<Leilao>();
        for(Leilao leilao : leiloes){
            if(!leilao.iSEncerrado()) filtrados.add(leilao);
        }
        return filtrados;
    }
    
    public void atualiza(Leilao leilao){
        //Faz NADA
    }

    public static List<Leilao> getLeiloes() {
        return leiloes;
    }

    public static void setLeiloes(List<Leilao> leiloes) {
        LeilaoDaoFalso.leiloes = leiloes;
    }
    
}
