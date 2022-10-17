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
        Cliente cli1 = new Cliente(10, "Ana Paula Alencar", "000.000.000-01","(00) 0 0000-0000", "Rua ali", "42", "", "bairro paz", "São Paulo", EstadoClienteSigla.SP);
        System.out.println("********************\n********************");
        testeListarCliente();
        System.out.println("********************\n********************");
        testeCriarCliente(cli1);
        System.out.println("********************\n********************");
        testeListarCliente();
        System.out.println("********************\n********************");

        System.out.println("********************\n********************");
        testeAtualizar(cli1);
        testeListarCliente();
        System.out.println("********************\n********************");

        System.out.println("********************\n********************");
        testeRemover(cli1);
        testeListarCliente();
        System.out.println("********************\n********************");
        
    }

    private static void testeCriarCliente(Cliente cliente) throws SQLException{

        try(Connection conn = new ConnectionFactory().conectar()){
            ClienteDAO clienteDAO = new ClienteDAO(conn);
            clienteDAO.criar(cliente);
        }
    }
    private static void testeListarCliente() throws SQLException {
        try(Connection conn = new ConnectionFactory().conectar()){
            ClienteDAO clienteDAO = new ClienteDAO(conn);
            List<Cliente> listaDeClientes = clienteDAO.consultar();
            listaDeClientes.stream().forEach(lc -> System.out.println(lc));
        }
    }
    private static void testeRemover(Cliente cliente) throws SQLException{
        try(Connection conn = new ConnectionFactory().conectar()){
            ClienteDAO clienteDAO = new ClienteDAO(conn);
            clienteDAO.remover(cliente);
        }
    }
    private static void testeAtualizar(Cliente cliente) throws SQLException{
        try(Connection conn = new ConnectionFactory().conectar()){
            ClienteDAO clienteDAO = new ClienteDAO(conn);
            clienteDAO.atualizar(cliente, cliente.getId());
        }
    }
}
