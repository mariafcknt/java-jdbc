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
        String sql = "call numero_ao_quadrado(?)";
        try(Connection con = FazerConexao.conectar();
            CallableStatement call = con.prepareCall(sql)){
                call.setInt(1,8);
                call.registerOutParameter(1, Types.INTEGER);
                call.execute();
                int numero = call.getInt("numero");
                System.out.println(numero);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
