package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.comex.DAO.CategoriaDAO;
import br.com.comex.DAO.ConnectionFactory;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.StatusCategoria;

public class MainInsercaoCategoria {
    public static void main(String[] args) throws SQLException {

        Categoria cat1 = new Categoria("INFORMÁTICA");
        Categoria cat2 = new Categoria("MÓVEIS", StatusCategoria.INATIVA);
        Categoria cat3 = new Categoria("LIVROS");

        try(Connection conn = new ConnectionFactory().conectar()){
            CategoriaDAO categoriaDAO = new CategoriaDAO(conn);
            categoriaDAO.criarCategoria(cat1);
            categoriaDAO.criarCategoria(cat2);
            categoriaDAO.criarCategoria(cat3);
        }
    }
}
