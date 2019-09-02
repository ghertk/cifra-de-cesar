package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection conexao;

    public static Connection obterConexao() throws Exception {
        try {

            String url = "jdbc:postgresql://localhost:5432/cifradecesar";
            String usuario = "postgres";
            String senha = "postgres";

            Class.forName("org.postgresql.Driver");

            Connection con = null;

            con = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Conexão realizada com sucesso.");
            
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        
        return null;
    }
}
