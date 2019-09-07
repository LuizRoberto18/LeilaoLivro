package edu.ifal.br.criador;

import java.util.Calendar;

import edu.ifal.br.modelo.Lance;
import edu.ifal.br.modelo.Leilao;
import edu.ifal.br.modelo.Session;
import edu.ifal.br.modelo.Usuario;

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
