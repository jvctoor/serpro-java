package mysql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UsuarioDAO_JPA {

    public EntityManager getEm() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return factory.createEntityManager();

    }

    /*public List<Usuario> findAll() {
        EntityManager em = this.getEm();

    }*/

    public Usuario insert(Usuario user) {
        EntityManager em = this.getEm();

        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return user;


    }

}
