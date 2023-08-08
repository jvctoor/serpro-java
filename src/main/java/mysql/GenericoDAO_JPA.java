package mysql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericoDAO_JPA<T extends EntidadeBase> {

    public EntityManager getEm() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        return factory.createEntityManager();
    }

    public T salvar(T t) throws Exception {
        EntityManager em = getEm();

        try {
            em.getTransaction().begin();
            if (t.getId() == null) {
                em.persist(t);
            } else {
               if (!em.contains(t)) {
                   if (em.find(t.getClass(), t.getId()) == null) {
                       throw new Exception("Erro ao atualizar");
                   }
               }
               t = em.merge(t);

            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        } finally {
            em.close();
        }

        return t;

    }

    public void deletar(T t) throws Exception {
        EntityManager em = getEm();

        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        } finally {
            em.close();
        }

    }

    public T getById(Class<T> clazz, Long id) throws Exception {

        EntityManager em = getEm();
        T t = null;

        try {
            em.getTransaction().begin();
            t = em.find(clazz, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.close();
        }

        return t;

    }
}
