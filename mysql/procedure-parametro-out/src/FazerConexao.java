package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FazerConexao {
    private static final String url = "jdbc:mysql://localhost:3306/meu_banco";

    //throws SQLException =
    public static Connection conectar() throws SQLException {
        Connection con = DriverManager.getConnection(url, "root", "root"); //usuário e senha do banco de dados
        return con;
    }
}
