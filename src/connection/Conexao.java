package connection;

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

            conexao = DriverManager.getConnection(url, usuario, senha);

            return conexao;
            
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
}
