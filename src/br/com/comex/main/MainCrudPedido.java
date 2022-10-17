package br.com.comex.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.comex.DAO.ConnectionFactory;
import br.com.comex.DAO.PedidoDAO;
import br.com.comex.modelo.Pedido;

public class MainCrudPedido {
    public static void main(String[] args) throws SQLException {
        Pedido cli1 = new Pedido(9, java.sql.Date.valueOf("2022-10-15"),13);
        System.out.println("********************\n********************");
        testeListarPedido();
        System.out.println("********************\n********************");
        testeCriarPedido(cli1);
        System.out.println("********************\n********************");
        testeListarPedido();
        System.out.println("********************\n********************");

        System.out.println("********************\n********************");
        testeAtualizar(cli1);
        testeListarPedido();
        System.out.println("********************\n********************");

        System.out.println("********************\n********************");
        testeRemover(cli1);
        testeListarPedido();
        System.out.println("********************\n********************");
        testeListarPedido();
    }

    private static void testeCriarPedido(Pedido pedido) throws SQLException{
        try(Connection conn = new ConnectionFactory().conectar()){
            PedidoDAO pedidoDAO = new PedidoDAO(conn);
            pedidoDAO.criar(pedido);
        }
    }
    private static void testeListarPedido() throws SQLException {
        try(Connection conn = new ConnectionFactory().conectar()){
            PedidoDAO pedidoDAO = new PedidoDAO(conn);
            List<Pedido> listaDePedidos = pedidoDAO.consultar();
            listaDePedidos.stream().forEach(lc -> System.out.println(lc));
        }
    }
    private static void testeRemover(Pedido pedido) throws SQLException{
        try(Connection conn = new ConnectionFactory().conectar()){
            PedidoDAO pedidoDAO = new PedidoDAO(conn);
            pedidoDAO.remover(pedido);
        }
    }
    private static void testeAtualizar(Pedido pedido) throws SQLException{
        try(Connection conn = new ConnectionFactory().conectar()){
            PedidoDAO pedidoDAO = new PedidoDAO(conn);
            pedidoDAO.atualizar(pedido);
        }
    }
}
