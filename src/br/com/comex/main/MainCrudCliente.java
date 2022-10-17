package br.com.comex.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.comex.DAO.ClienteDAO;
import br.com.comex.DAO.ConnectionFactory;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.EstadoClienteSigla;

public class MainCrudCliente {
    public static void main(String[] args) throws SQLException {
        Cliente cli1 = new Cliente(1, "Ana Paula Souza", "000.000.000-00","(00) 0 0000-0000", "Rua ali", "42", "", "bairro paz", "São Paulo", EstadoClienteSigla.SP);

        testeListarCliente();
        testeCriarCliente(cli1);
        testeListarCliente();

        testeAtualizar(cli1, 8);
        testeListarCliente();

        testeRemover(8);
        testeListarCliente();
        
    }

    private static void testeCriarCliente(Cliente cli) throws SQLException{

        try(Connection conn = new ConnectionFactory().conectar()){
            ClienteDAO clienteDAO = new ClienteDAO(conn);
            clienteDAO.criar(cli);
        }
    }
    private static void testeListarCliente() throws SQLException {
        try(Connection conn = new ConnectionFactory().conectar()){
            ClienteDAO clienteDAO = new ClienteDAO(conn);
            List<Cliente> listaDeClientes = clienteDAO.consultar();
            listaDeClientes.stream().forEach(lc -> System.out.println(lc));
        }
    }
    private static void testeRemover(int id) throws SQLException{
        try(Connection conn = new ConnectionFactory().conectar()){
            ClienteDAO clienteDAO = new ClienteDAO(conn);
            clienteDAO.remover(id);
        }
    }
    private static void testeAtualizar(Cliente cli, int id) throws SQLException{
        try(Connection conn = new ConnectionFactory().conectar()){
            ClienteDAO clienteDAO = new ClienteDAO(conn);
            clienteDAO.atualizar(cli, id);
        }
    }
}
