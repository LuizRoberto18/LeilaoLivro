package com.mycompany.leilao;
public class CriadorDeLeilao {
    private Leilao leilao;
    
    public CriadorDeLeilao(){}
    
    public CriadorDeLeilao para(String descricao){
        this.leilao = new Leilao();
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
}
