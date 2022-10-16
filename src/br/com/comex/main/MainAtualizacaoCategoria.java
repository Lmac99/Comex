package br.com.comex.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.DAO.CategoriaDAO;
import br.com.comex.DAO.ConnectionFactory;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.StatusCategoria;

public class MainAtualizacaoCategoria {
    public static void main(String[] args) throws SQLException {
        Categoria cat = new Categoria(19, "LIVROS TÉCNICOS", StatusCategoria.ATIVA);

        try(Connection conn = new ConnectionFactory().conectar()){
            CategoriaDAO categoriaDAO = new CategoriaDAO(conn);
            categoriaDAO.atualizarCategoria(cat);
        }
    }
}
