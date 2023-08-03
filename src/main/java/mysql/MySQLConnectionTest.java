package mysql;

import mysql.model.Usuario;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.HibernateUtil;

import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MySQLConnectionTest {

    // Anotações do JUnit
    // @BeforeAll @BeforeEach
    // @AfterAll @AfterEach

    UsuarioDAO_JPA jpa_dao;

    @Test
    @BeforeAll
    @DisplayName("Setup DAO")
    void instanciarDAO() {
        jpa_dao = new UsuarioDAO_JPA();
        System.out.println("DAO Instanciado");
    }

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

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L, 4L, 5L})
    @DisplayName("Get by id - JPA")
    void jpaGetUserById(Long id) throws Exception {
        Usuario user = jpa_dao.getById(id);
        Assertions.assertEquals(id, user.getId());
    }

    @RepeatedTest(value=2)
    @DisplayName("Should not delete anyone if the id is null")
    void shouldNotDeleteAnyoneIfIdIsNull() {
        Assertions.assertThrows(Exception.class, () -> {
            jpa_dao.removeById(null);
        });
    }






}
