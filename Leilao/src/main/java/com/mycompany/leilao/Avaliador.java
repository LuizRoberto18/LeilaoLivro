package com.mycompany.leilao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Avaliador {
    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private List<Lance >maiores;
    
    public void avaliar(Leilao leilao){
        //laçand a exceçao
        if(leilao.getLances().size() == 0)
            throw new RuntimeException(
            "Não é possivel avaliar um leilão sem lances"
            );
        for(Lance lance : leilao.getLances()){
            if(lance.getValor() > maiorDeTodos)
                maiorDeTodos = lance.getValor();
            if(lance.getValor() < menorDeTodos)
                menorDeTodos = lance.getValor();
        }
      
        tresMaiores(leilao);
    }
    public void pegaOsMaioresNo(Leilao leilao){
        maiores new ArrayList<Lance.(leilao.getLances());
        Collections.sort(maiores, new Comparator<Lance>(){
            public int compare(Lance 01, Lance 02){
                if(01.getValor() < 02.getValor()) return 1;
                if(01.getValor() > 02.getValor()) return -1;
                return 0;
            	}
            });
            maiores = maiores.subList(0, 3);
    }
    
    public List<Lance> getTresMaiores(){
        return this.maiores;
    }
    public double getMaiorLance(){
        return maiorDeTodos;
    }
    public double getMenorLance(){
        return menorDeTodos;
    }
    
}
