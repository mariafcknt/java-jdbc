package src;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

//Adicionar biblioteca mysql:mysql-connector-java

public class Main {
    public static void main(String[] args) {
        chamarComParametroOut();
    }

    public static void chamarComParametroOut(){
        String sql = "call obter_numero_aleatorio(?)"; //procedure SQL
        try(Connection con = FazerConexao.conectar();
            //CallableStatement = permite executar comandos armazenados no banco de dados
            //prepareCall() = método que cria o objeto CallableStatement e recebe como parâmetro a chamada a procedure
            CallableStatement call = con.prepareCall(sql)){
            call.registerOutParameter(1, Types.INTEGER);
            call.execute();
            System.out.println(call.getInt(1));
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
