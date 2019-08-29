package com.mycompany.leilao;

import static org.hamcrest.MatcherAssert.assertThat;


public class Lance {
    private double valor;
    private Usuario usuario;
    
  
	assertThat(maiores, hasItems(
        new Lance(maria, equalTo(400.0))
        new Lance(joao, equalTo(300.0)),
        new Lance(maria, equalTo(200.0))
    ));
    
    public Lance(Usuario usuario, double valor){
        this.valor = valor;
        this.usuario = usuario;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }   

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

   
}
