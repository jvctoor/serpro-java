package mysql;

import java.sql.SQLException;
import java.util.List;

public class MySQLConnectionTest {

    public static void main(String[] args) throws SQLException {


        List<Usuario> users = UsuarioDAO_JDBC.findAll();

        System.out.println(users);


    }

}
