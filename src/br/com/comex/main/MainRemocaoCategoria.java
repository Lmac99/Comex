package br.com.comex.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.DAO.CategoriaDAO;
import br.com.comex.DAO.ConnectionFactory;

public class MainRemocaoCategoria {
    public static void main(String[] args) throws SQLException {
        try(Connection conn = new ConnectionFactory().conectar()){
            CategoriaDAO categoriaDAO = new CategoriaDAO(conn);
            categoriaDAO.removerCategoria("INATIVA");
        }
    }
    
}
