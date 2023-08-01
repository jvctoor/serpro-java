package mysql;


import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO_JDBC {

    static String url = "jdbc:mysql://127.0.0.1:3306/serpro?useSSL=false";
    static String user = "root";
    static String password = "15902332";

    public static List<Usuario> findAll() {


        String query = "select * from usuarios;";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            List<Usuario> usuarios = new ArrayList<>();

            while(rs.next()) {
                Usuario usuario = new Usuario(rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getInt("idade"),
                        rs.getDate("data_cadastro"));

                usuarios.add(usuario);

            }

            rs.close();
            st.close();
            con.close();

            return usuarios;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public static Usuario getUsuarioByID(int id) throws SQLException {
        String query = "select * from usuarios where id =" + Integer.toString(id);

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            rs.next();

            Usuario usuario = new Usuario(rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getInt("idade"),
                    rs.getDate("data_cadastro"));

            con.close();
            st.close();
            rs.close();

            return usuario;

        } catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
