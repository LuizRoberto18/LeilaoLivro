package com.mycompany.leilao;
public class UsuarioDao {
    private final Session session;
    
    public UsuarioDao(Session session){
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
    
    public static void salvar(Usuario usuario){
        Session.save(usuario);
    }

    public Session getSession() {
        return session;
    }
    
    public static void deletar(Usuario usuario){
        Session.delete(usuario);
    }
}
