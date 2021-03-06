package edu.ifal.br.dao;

import java.util.Calendar;
import java.util.List;

import edu.ifal.br.modelo.Leilao;
import edu.ifal.br.modelo.Session;

public class LeilaoDao {
	
	private Session session;
	
    public Long total(){
        return (Long) Session.createQuery("select count(1) from" 
                + "Leilao 1 where 1.encerrado = false");
    }
     public void salvar(Leilao leilao){
        session.save(leilao);
    }
     
    public List<Leilao> porPeriodo(Calendar inicio, Calendar fim){
        return Session.createQuery("from Leilao 1 where 1.dataAbertura"
        + "between :inicio and :fim and 1.encerrado = false")
                .setParameter("inicio", inicio)
                .setParameter("fim", fim)
                .list();
    }
    
    public LeilaoDao(Session session) {
    	this.session = session;
    }
}
