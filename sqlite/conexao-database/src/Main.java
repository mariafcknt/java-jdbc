package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//Conexão com banco de dados sqlite
//Precisa da biblioteca Maven org.xerial:sqlite-jdbc adicionada ao projeto

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:meu_banco.sqlite"; //indica qual banco de dados deve ser conectado

        //vai tentar executar o código e se houver uma exceção/erro vai para o catch
        try(Connection con = DriverManager.getConnection(url)){
            //o Driver estabelece a conexão com o banco de dados e armazena ela no objeto Connection con
            System.out.println("Conexão foi um sucesso!");
            //Statement = Interface que contêm as funções essenciais para executar comandos SQL
            Statement stat = con.createStatement();
        } catch (Exception e){
            e.printStackTrace(); //imprime a exceção "e" que é criada caso o try não funcione
            System.out.println("Erro ao tentar executar");
        }
    }
}
