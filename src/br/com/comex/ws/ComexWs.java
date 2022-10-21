package br.com.comex.ws;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.jws.WebService;

import br.com.comex.DAO.CategoriaDAO;
import br.com.comex.DAO.ConnectionFactory;
import br.com.comex.modelo.Categoria;

@WebService
public class ComexWs {

    private CategoriaDAO dao;
    

    public List<Categoria> getCategorias() throws SQLException{
        try(Connection conn = new ConnectionFactory().conectar()){
            dao = new CategoriaDAO(conn);
            return dao.consultaCategorias();
        }
    }
}
