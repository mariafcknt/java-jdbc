package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306";
        //Não estava conectando com a URL "jdbc:mysql:localhost:3306"

        //Adicionar biblioetaca mysql:mysql-connector-java

        try {
            DriverManager.getConnection(url, "root","root");
            System.out.println("Conexão estabelecida");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Falha ao estabelecer conexão");
        }
        
    }
}
