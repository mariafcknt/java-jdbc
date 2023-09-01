package src;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

//Adicionar biblioteca mysql:mysql-connector-java

public class Main {
    public static void main(String[] args) {
        chamarComParametroInOut();
    }

    public static void chamarComParametroInOut(){
        String sql = "call numero_ao_quadrado(?)"; //chamada a procedure SQL, o parâmetro será enviado no lugar do ?
        try(Connection con = FazerConexao.conectar(); //estabelecer conexão com o banco de dados
            //CallableStatement = permite executar comandos armazenados no banco de dados
            //prepareCall() = método que cria o objeto CallableStatement e recebe como parâmetro o comando SQL
            CallableStatement call = con.prepareCall(sql)){
                call.setInt(1,8); //define o valor do primeiro parâmetro de entrada da procedure
                call.registerOutParameter(1, Types.INTEGER); //define o primeiro parâmetro como de saída e o tipo esperado
                call.execute(); //execução da procedure
                int numero = call.getInt("numero"); //pega o valor de saída da procedure que foi registrado como parâmetro de saída
                System.out.println(numero);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
