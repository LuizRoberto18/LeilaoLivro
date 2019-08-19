package com.mycompany.leilao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Leilao {
   private String descricao;
   private List<Lance> lances;
   private Date data;
   private Date dataAbertura;
   private String nome;
   
   public Leilao(String descricao) {
	   this.descricao = descricao;
   }
   
   public Leilao(String descricao, double d, Usuario usuario, boolean b) {
	  
   }
   

public Leilao(String descricao, List<Lance> lances){
       this.descricao = descricao;
       this.lances = new ArrayList<Lance>();
   }

public Leilao() {
      
    }
    
   public void encerra(){
       
   }
   
   public void propoe(Lance lance){
       lances.add(lance);
   } 

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Lance> getLances() {
        return Collections.unmodifiableList(lances);
    }

    public void setLances(List<Lance> lances) {
        this.lances = lances;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean iSEncerrado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataAbertura(Calendar dataDoLeilao1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
   
}