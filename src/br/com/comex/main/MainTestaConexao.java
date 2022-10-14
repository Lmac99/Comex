package br.com.comex.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.DAO.ConnectionFactory;

public class MainTestaConexao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection conn = connectionFactory.conectar();

        System.out.println("Conexão efetuada com sucesso");

        conn.close();
    }
}
