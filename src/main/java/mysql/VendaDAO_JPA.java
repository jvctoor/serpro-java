package mysql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.rmi.server.ExportException;
import java.util.List;

public class VendaDAO_JPA {

    private EntityManager getEm() {
        EntityManagerFactory em = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return em.createEntityManager();
    }

    public void salvar(Venda venda) throws Exception {
        EntityManager em = getEm();

        try {
            em.getTransaction().begin();
            if (venda.getId() == null) {
                em.persist(venda);
            } else {
                em.merge(venda);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        } finally {
            em.close();
        }
    }

    public Venda getById(Long id) throws Exception {
        EntityManager em = getEm();
        try {
            return em.find(Venda.class, id);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.close();
        }
    }

}
