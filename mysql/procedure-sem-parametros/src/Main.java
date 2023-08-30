package src;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

//Adicionar biblioteca mysql:mysql-connector-java


public class Main {
    public static void main(String[] args) {
        chamarSemParametro();
    }

    public static void chamarSemParametro(){
        String sql = "call ler_nomes_que_inicia_com_t()"; //nome da procedure SQL
        try(Connection con = FazerConexao.conectar();
            //CallableStatemnt = permite executar comandos armazenados no banco de dados
            //prepareCall() = usado para criar o objeto CallableStatement, a string sql será passada como parâmetro
            CallableStatement call = con.prepareCall(sql)) {
            //ResultSet = realiza a leitura dos resultados de uma query (consulta)
            //executeQuery = função para instruções SELECT da interface Statement
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nome"));
                System.out.println(" " + rs.getString("sobrenome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
