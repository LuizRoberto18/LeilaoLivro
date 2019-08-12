package com.mycompany.leilao;

import java.util.Calendar;
import java.util.List;

public class LeilaoDao {
    
    public Long total(){
        return (Long) session.createQuery("select count(1) from" 
                + "Leilao 1 where 1.encerrado = false")
    }
     public void salvar(Leilao leilao){
        session.save(leilao);
    }
     
    public List<Leilao> porPeriodo(Calendar inicio, Calendar fim){
        return session.createQuery("from Leilao 1 where 1.dataAbertura"
        + "between :inicio and :fim and 1.encerrado = false")
                .setParameter("inicio", inicio)
                .setParameter("fim", fim)
                .list();
    }
}
