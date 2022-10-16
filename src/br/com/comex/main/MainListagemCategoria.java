package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.comex.DAO.CategoriaDAO;
import br.com.comex.DAO.ConnectionFactory;
import br.com.comex.modelo.Categoria;

public class MainListagemCategoria {
    public static void main(String[] args) throws SQLException {
        try(Connection conn = new ConnectionFactory().conectar()){
            CategoriaDAO categoriaDAO = new CategoriaDAO(conn);
            List<Categoria> listaDeCategorias = categoriaDAO.consultaCategoria();
            listaDeCategorias.stream().forEach(lc -> System.out.println(lc));
        }
    }
}
