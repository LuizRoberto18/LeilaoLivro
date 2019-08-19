package com.mycompany.leilao;

public class Lance {
    private double valor;
    private Usuario usuario;
    
  
	void assertThat(maiores, hasItems(
       new Lance(maria, 400.0),
        new Lance(joao, 300.0),
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
	public static void add(Lance lance) {
		// TODO Auto-generated method stub
		
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	public static void lance(String string, int i) {
		// TODO Auto-generated method stub
		
	}
	public static Object existeLance(String string) {
		// TODO Auto-generated method stub
		return null;
	}

   
}
