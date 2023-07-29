import java.sql.*;

public class MySQLConnector {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://127.0.0.1:3306/serpro?useSSL=false";
        String user = "root";
        String password = "15902332";

        String query = "select * from usuarios;";

        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            System.out.println("ID: " + id + " | Nome: " + nome);
        }

        rs.close();
        st.close();
        con.close();

    }

}
