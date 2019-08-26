package com.mycompany.leilao;

import java.util.List;

import com.mycompany.leilao.Lance;

public class Usuario {
    
    private String usuario;
    private String nome;
    private String email;
    private List<Lance> lances;
   

	public   Usuario(String usuario, String nome, String email){
        this.email = email;
        this.nome = nome;
        this.usuario = usuario;
    }
    
    public  Usuario(String nome) {
    	this.nome = nome;
    }
    
    public Usuario(String nome , String email) {
    	this.nome = nome;
    	this.email = email;
    }
    public void propoe(Lance lance){
        if(lances.isEmpty() || podeDarLance(lance.getUsuario()))
        {
            lances.add(lance);
        }
    }
    
    private int qtdDeLancesDo(Usuario usuario){
        int total = 0;
        for(Lance lance : lances){
            if(lance.getUsuario().equals(usuario)) total++;
        }
        return total;
    }
    
    private boolean podeDarLance(Usuario usuario){
        return !ultimoLanceDado().getUsuario().equals(usuario)
                && qtdDeLancesDo(usuario) < 5;
    }
    
    private Lance ultimoLanceDado(){
        return lances.get(lances.size()-1);
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
 
}
