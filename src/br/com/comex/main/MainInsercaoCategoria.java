package br.com.comex.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.DAO.ConnectionFactory;

public class MainInsercaoCategoria {
    public static void main(String[] args) throws SQLException {
        try{
            String query = "INSERT INTO comex.categoria (NOME, STATUS) VALUES ('TESTE', 'ATIVA')";
            ConnectionFactory connectionFactory = new ConnectionFactory();
            Connection conn = connectionFactory.conectar();

            Statement stmt = conn.createStatement();
            int count = stmt.executeUpdate(query);

            System.out.println("Number of rows updated in database =  " + count);

            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
