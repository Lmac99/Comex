package br.com.comex.ws;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.comex.DAO.CategoriaDAO;
import br.com.comex.DAO.ConnectionFactory;
import br.com.comex.modelo.Categoria;

@WebService
public class ComexWs {

    private CategoriaDAO dao;
    
    @WebMethod(operationName="listaTodasCategorias")
    @WebResult(name="categoria")
    public List<Categoria> getCategorias() throws SQLException{
        try(Connection conn = new ConnectionFactory().conectar()){
            dao = new CategoriaDAO(conn);
            return dao.consultaCategorias();
        }
    }

    @WebMethod(operationName="adicionaNovaCategoria")
    @WebResult(name="categoria")
    public Categoria adicionarCategoria(@WebParam(name="categoria") String nomeCategoria) throws SQLException{
        try(Connection conn = new ConnectionFactory().conectar()){
            Categoria categoria = new Categoria(nomeCategoria);
            dao = new CategoriaDAO(conn);
            System.out.println("Adicionando Categoria");
            dao.criarCategoria(categoria);
            return categoria;
        }
    }
}
