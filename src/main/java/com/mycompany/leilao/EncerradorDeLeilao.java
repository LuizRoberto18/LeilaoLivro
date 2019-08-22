package com.mycompany.leilao;

import java.util.Calendar;
import java.util.List;

public class EncerradorDeLeilao{
    
    private int total = 0;
    private final LeilaoDao dao;
    private final RepositorioDeLeiloes dao;
    private final Carteiro carteiro;
    
    public void EcerradorDeLeilao(RepositorioDeLeiloes dao, Carteiro carteiro){
        this.dao = dao;
        this.carteiro = carteiro;
    }
    public void encerra(){
        List<Leilao> todosLeiloesCorrentes = dao.correntes();
        
        for(Leilao leilao : todosLeiloesCorrentes){
            try{
                if(comecouSemanaPassada(leilao)){
                    leilao.encerra();
                    total++;
                    dao.atulizar(leilao);
                    carteiro.envia(leilao);
                }
            }
            catch(Exception e){
                //salvo a exceção no sistema de logs e o loop continua
           }
        }
    }
    
    private boolean comecouSemanaPassada(Leilao leilao){
        return diasEntre(leilao.getData(), Calendar.getInstance()) >= 7;
    }
    
    private int diasEntre(Calendar inicio, Calendar fim){
        Calendar data = (Calendar) inicio.clone();
        int diasNoIntervalo = 0;
        
        while(data.before(fim)){
            data.add(Calendar.DAY_OF_MONTH, 1);
            diasNoIntervalo++;
        }
        return diasNoIntervalo;
    }
    
    public int getTotalEncerrados(){
        return this.total;
    }
}
