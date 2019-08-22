package com.mycompany.leilao;

public class Lance {
    private double valor;
    private Usuario usuario;
    
  
	assertThat(maiores, hasItems(
        new Lance(maria, 400.0)
        new Lance(joao, 300.0)
        new Lance(maria, 200.0)
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

   
}
