package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.DAO.ConnectionFactory;

public class MainListagemCategoria {
    public static void main(String[] args) throws SQLException {
        try{
            String query = "SELECT NOME, STATUS FROM comex.categoria";
            ConnectionFactory connectionFactory = new ConnectionFactory();
            Connection conn = connectionFactory.conectar();

            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.execute();
            ResultSet rst = stmt.getResultSet();
            while(rst.next()){
                String nome = rst.getString("NOME");
                System.out.println(nome);

                String status = rst.getString("STATUS");
                System.out.println(status);
            }
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
