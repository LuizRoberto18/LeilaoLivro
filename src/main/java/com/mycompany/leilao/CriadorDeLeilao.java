package com.mycompany.leilao;

import java.util.Calendar;

public class CriadorDeLeilao {
    private Leilao leilao;
    
    public CriadorDeLeilao(){}
    
    public CriadorDeLeilao para(String descricao){
        this.leilao = new Leilao(descricao);
        return this;
    }
    public CriadorDeLeilao lance(Usuario usuario, double valor){
        leilao.propoe(new Lance(usuario, valor));
        return this;
    }
    public Leilao constroi(){
        return leilao;
    }

	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public CriadorDeLeilao naData(Calendar antiga) {
		// TODO Auto-generated method stub
		return null;
	}
}
