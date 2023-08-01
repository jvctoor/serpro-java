package mysql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.HibernateUtil;

import java.sql.SQLException;
import java.util.List;


public class MySQLConnectionTest {

    @Test
    @DisplayName("Get all - Hibernate")
    void hibernateGetAllUsers() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        UsuarioDAO_Hibernate dao = new UsuarioDAO_Hibernate(factory);
        List<Usuario> users = dao.findAll();
        Assertions.assertNotEquals(null, users);
    }

    @Test
    @DisplayName("Get all - JDBC")
    void jdbcGetAllUsers() {
        UsuarioDAO_JDBC dao = new UsuarioDAO_JDBC();
        List<Usuario> users = dao.findAll();
        Assertions.assertNotEquals(null, users);
    }

    @Test
    @DisplayName("Get by id - JPA")
    void jpaGetUserById() throws Exception {
        UsuarioDAO_JPA dao = new UsuarioDAO_JPA();
        Usuario user = dao.getById(15L);
        Assertions.assertEquals(15L, user.getId());
    }

}
