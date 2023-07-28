import com.mysql.jdbc.Driver;
import java.sql.*;

public class Main {

    static String url = "jdbc:mysql://localhost:3306/?user=root";
    static String user = "localhost";
    static String password = "";
    public static void main(String[] args) throws SQLException {
        System.out.println("Olá SERPRO");

        Connection con = DriverManager.getConnection(url);



    }
}




