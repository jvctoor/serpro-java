package mysql;

import mysql.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioDAO_JPA {

    public EntityManager getEm() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return factory.createEntityManager();

    }

    public Usuario save(Usuario usuario) throws Exception {
        EntityManager em = getEm();

        try {
            em.getTransaction().begin();
            if (usuario.getId() == null) {
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
            return em.find(Usuario.class, id);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.close();
        }

    }

}
