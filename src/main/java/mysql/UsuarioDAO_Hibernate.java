package mysql;

import mysql.model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UsuarioDAO_Hibernate {

    private final SessionFactory sessionFactory;

    public UsuarioDAO_Hibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Usuario> findAll() {
        Session session = sessionFactory.openSession();
        List<Usuario> usuarios = session.createQuery("select u from Usuario u", Usuario.class).list();
        session.close();
        return usuarios;
    }



}
