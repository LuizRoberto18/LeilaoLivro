package com.mycompany.leilao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EncerradorDeLeilao{
    
    private int total = 0;
    private final LeilaoDao dao;
    private final RepositorioDeLeiloes repositorioDeLeiloesDao;
    private final Carteiro carteiro;
    
    public void EcerradorDeLeilao(RepositorioDeLeiloes repositorioDeLeiloesDao, Carteiro carteiro){
        this.repositorioDeLeiloesDao = repositorioDeLeiloesDao;
        this.carteiro = carteiro;
    }
    public void encerra(){
        List<Leilao> todosLeiloesCorrentes = repositorioDeLeiloesDao.correntes();
        
        for(Leilao leilao : todosLeiloesCorrentes){
            try{
                if(comecouSemanaPassada(leilao)){
                    leilao.encerra();
                    total++;
                    repositorioDeLeiloesDao.atulizar(leilao);
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
    
    private int diasEntre(Date date, Calendar fim){
        Calendar data = (Calendar) date.clone();
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
