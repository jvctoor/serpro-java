package mysql;

import java.sql.SQLException;
import java.util.List;

public class MySQLConnectionTest {

    public static void main(String[] args) throws SQLException {

        UsuarioDAO_JDBC userDao = new UsuarioDAO_JDBC();
        List<Usuario> users = userDao.findAll();

        Usuario userByID = userDao.getUsuarioByID(1);

        System.out.println(userByID);


    }

}
