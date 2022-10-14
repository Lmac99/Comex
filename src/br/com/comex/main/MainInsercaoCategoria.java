package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.DAO.ConnectionFactory;

public class MainInsercaoCategoria {
    public static void main(String[] args) throws SQLException {
        String nome = "TESTE 3";
        String status = "INATIVA";
        String query = "INSERT INTO comex.categoria (NOME, STATUS) VALUES (?, ?)";

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection conn = connectionFactory.conectar();
        conn.setAutoCommit(false);

        try(PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {  
            adicionarVariavel(nome, status, stmt);
            adicionarVariavel("TESTE 2", "ATIVA", stmt);

            conn.commit();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ROLLBACK INICIADO");
            conn.rollback();
        }
    }

    private static void adicionarVariavel(String nome, String status, PreparedStatement stmt) throws SQLException{
        stmt.setString(1, nome);
        stmt.setString(2, status);

        stmt.execute();

        System.out.println("Number of rows updated in database =  " + stmt.getUpdateCount());
    }
}
