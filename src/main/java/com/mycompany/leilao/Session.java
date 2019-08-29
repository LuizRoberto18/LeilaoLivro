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

    void save(Leilao leilao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	public static Object createQuery(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public Usuario load(Class<Usuario> class1, int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void beginTransaction() {
		// TODO Auto-generated method stub
		
	}
	public Object getTransaction() {
		// TODO Auto-generated method stub
		return null;
	}
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
	public static void flush() {
		// TODO Auto-generated method stub
		
	}

}
