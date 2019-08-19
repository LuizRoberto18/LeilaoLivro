package com.mycompany.leilao;
public class Session {
    
   private String session;
   
   public Session(String session) {
	   this.session = session;
   }
   public void CriadorDeSessao(){
       
   }
   
   public void close(){
       
   }
   
    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    void delete(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void save(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
