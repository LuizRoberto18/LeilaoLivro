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

    static void delete(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void save(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	public static Object createQuery(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void save(Leilao leilao) {
		// TODO Auto-generated method stub
		
	}
	public Usuario load(Class<Usuario> class1, int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void beginTransaction() {
		// TODO Auto-generated method stub
		
	}

}
