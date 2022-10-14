package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.DAO.ConnectionFactory;

public class MainRemocaoCategoria {
    public static void main(String[] args) throws SQLException {
        String query = "DELETE FROM comex.categoria WHERE STATUS = ?";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection conn = connectionFactory.conectar();
        conn.setAutoCommit(false);

        try(PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, "INATIVA");
            stmt.execute();
            Integer linhasModificadas = stmt.getUpdateCount();
            
            conn.commit();
            System.out.println("Linhas modificadas "+linhasModificadas);


        }catch(SQLException e){
            System.out.println(e);
            System.out.println("ROLLBACK INICIADO");
            conn.rollback();
        }
    }
    
}
