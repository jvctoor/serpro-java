package mysql;

import java.sql.*;
import java.util.List;

public class MySQLConnectionTest {

    public static void main(String[] args) {

        UsuarioDAO userDao = new UsuarioDAO();
        List<Usuario> users = userDao.findAll();

        System.out.println(users);


    }

}
