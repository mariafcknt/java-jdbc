package src;

//Adicionar biblioteca mysql:mysql-connector-java

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        chamarComParametroIn();
    }

    public static void chamarComParametroIn(){
        String sql = "call ler_nomes_que_inicia_com_a_letra(?)"; //variável com o nome da procedure
        try(Connection con = FazerConexao.conectar(); //tenta se conectar com o banco de dados e caso houver erro vai para o catch
            //CallableStatement = permite executar comandos armazenados no banco de dados
            //prepareCall() = método da interface connection que cria o objeto CallableStatement e tem como parâmetro a variável sql
            CallableStatement call = con.prepareCall(sql)){
            call.setString("letra","J"); //nome e valor do parâmetro que será passado para a procedure
            //executeQuery() = método  para instruções SELECT da interface Statement
            ResultSet rs = call.executeQuery(); //ResultSet = lê os resultados de uma query/consulta
            while(rs.next()){
                System.out.println(rs.getString("nome"));
                System.out.println(" " + rs.getString("sobrenome"));
            }
        } catch (SQLException e){
            e.printStackTrace(); //imprime o erro gerado se o try não funcionar
        }
    }
}
