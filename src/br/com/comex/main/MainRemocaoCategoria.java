package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.comex.DAO.CategoriaDAO;
import br.com.comex.DAO.ConnectionFactory;

public class MainRemocaoCategoria {
    public static void main(String[] args) throws SQLException {
        try(Connection conn = new ConnectionFactory().conectar()){
            CategoriaDAO categoriaDAO = new CategoriaDAO(conn);
            categoriaDAO.removerCategoria();
        }
    }
    
}
