package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public List<Usuario> findAll() {
        String url = "jdbc:mysql://127.0.0.1:3306/serpro?useSSL=false";
        String user = "root";
        String password = "15902332";

        String query = "select * from usuarios;";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            List<Usuario> usuarios = new ArrayList<>();

            while(rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("id"),
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

}
