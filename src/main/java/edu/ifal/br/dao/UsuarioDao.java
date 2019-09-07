package edu.ifal.br.dao;

import edu.ifal.br.modelo.Session;
import edu.ifal.br.modelo.Usuario;

public class UsuarioDao {
	
    private final Session session;
    
    public UsuarioDao(){
    	
    }
            
    public UsuarioDao(Session session) {
		this.session = session;
	}

	public Usuario porId(int id){
        return (Usuario) session.load(Usuario.class, id);
    }
    
    public Usuario porNomeEEmail(String nome, String email){
        return (Usuario) Session.createQuery(
                "from Usuario u where u.nome = :nome and x.email = :email")
                .setParameter("nome", nome)
                .setParameter("email", email)
                .uniqueResult();
    }
    
    public void salvar(Usuario usuario){
        session.save(usuario);
    }

    public Session getSession() {
        return session;
    }
    
    public void deletar(Usuario usuario){
        session.delete(usuario);
    }
}
