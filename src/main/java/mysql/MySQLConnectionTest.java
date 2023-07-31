package mysql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

public class MySQLConnectionTest {

    public static void main(String[] args) throws SQLException {

        SessionFactory factory = HibernateUtil.getSessionFactory();

        UsuarioDAO_Hibernate dao = new UsuarioDAO_Hibernate(factory);
        List<Usuario> users = dao.findAll();

        System.out.println(users);


    }

}
