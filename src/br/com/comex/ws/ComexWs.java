package br.com.comex.ws;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.comex.DAO.CategoriaDAO;
import br.com.comex.DAO.ClienteDAO;
import br.com.comex.DAO.ConnectionFactory;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.EstadoClienteSigla;

@WebService
public class ComexWs {

    private CategoriaDAO daoCategoria;
    private ClienteDAO daoCliente;
    
    //OPERACOES REFERENTES A CATEGORIA
    @WebMethod(operationName="listarCategorias")
    @WebResult(name="categoria")
    public List<Categoria> getCategorias() throws SQLException{
        try(Connection conn = new ConnectionFactory().conectar()){
            daoCategoria = new CategoriaDAO(conn);
            return daoCategoria.consultaCategorias();
        }
    }


    @WebMethod(operationName="adicionaNovaCategoria")
    @WebResult(name="categoria")
    public Categoria adicionarCategoria(@WebParam(name="categoria") String nomeCategoria) throws SQLException{
        try(Connection conn = new ConnectionFactory().conectar()){
            Categoria categoria = new Categoria(nomeCategoria);
            daoCategoria = new CategoriaDAO(conn);
            System.out.println("Adicionando Categoria");
            daoCategoria.criarCategoria(categoria);
            return categoria;
        }
    }
    // FIM OPERACOES REFERENTES A CATEGORIA

    // OPERACOES REFERENTES AOS CLIENTES
    @WebMethod(operationName="listaTodosClientes")
    @WebResult(name="cliente")
    public List<Cliente> listarClientes() throws SQLException{
        try(Connection conn = new ConnectionFactory().conectar()){
            daoCliente = new ClienteDAO(conn);
            return daoCliente.consultar();
        }
    }
    @WebMethod(operationName="adicionaNovoCliente")
    @WebResult(name="cliente")
    public Cliente adicionarCliente(@WebParam(name="nome") String nome,@WebParam(name="cpf") String cpf,@WebParam(name="rua") String rua,@WebParam(name="numero") String numero,@WebParam(name="complemento") String complemento,@WebParam(name="bairro") String bairro,@WebParam(name="cidade") String cidade,@WebParam(name="UF") EstadoClienteSigla estado) throws SQLException{
        try(Connection conn = new ConnectionFactory().conectar()){
            Cliente cliente = new Cliente(0, nome, cpf, rua, numero, bairro, cidade, estado);
            daoCliente = new ClienteDAO(conn);
            System.out.println("Adicionando Cliente");
            daoCliente.criar(cliente);
            return cliente;
        }
    }
}
