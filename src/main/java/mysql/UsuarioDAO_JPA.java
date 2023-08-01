package mysql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDAO_JPA {

    public EntityManager getEm() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return factory.createEntityManager();

    }

    public Usuario save(Usuario usuario) throws Exception {
        EntityManager em = getEm();

        try {
            em.getTransaction().begin();
            if (usuario.getId() == 0) {
                em.persist(usuario); // insert
            } else {
                if(!em.contains(usuario)) {
                    if(em.find(Usuario.class, usuario.getId()) == null) {
                        throw new Exception("Erro ao atualizar os dados");
                    }
                }
                em.merge(usuario); // update
            }
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            throw new Exception(e);
        } finally {
            em.close();
        }

        return usuario;
    }

    public void removeById(Long id) throws Exception {

        EntityManager em = getEm();

        try {
            em.getTransaction().begin();
            Usuario user = em.find(Usuario.class, id);
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            throw new Exception(e);
        } finally {
            em.close();
        }

    }

    public Usuario getById(Long id) throws Exception {
        EntityManager em = getEm();

        try {
            Usuario user = em.find(Usuario.class, id);
            return user;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.close();
        }

    }

}
