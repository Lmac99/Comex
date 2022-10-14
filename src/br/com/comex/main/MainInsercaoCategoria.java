package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.DAO.ConnectionFactory;

public class MainInsercaoCategoria {
    public static void main(String[] args) throws SQLException {
        try{
            String nome = "TESTE";
            String status = "INATIVA";
            String query = "INSERT INTO comex.categoria (NOME, STATUS) VALUES (?, ?)";
            ConnectionFactory connectionFactory = new ConnectionFactory();
            Connection conn = connectionFactory.conectar();

            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, nome);
            stmt.setString(2, status);

            stmt.execute();

            ResultSet rst = stmt.getGeneratedKeys();
            System.out.println("Number of rows updated in database =  " + stmt.getUpdateCount());
            System.out.println("Number of rows updated in database =  " + rst.getMetaData());

            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
