package br.com.comex.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.comex.DAO.ConnectionFactory;
import br.com.comex.DAO.ProdutoDAO;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.ProdutoIsento;
import br.com.comex.modelo.TipoProduto;

public class MainCrudProduto {
    public static void main(String[] args) throws SQLException {
        testeListarProduto();
        testeCriarProduto();
        testeRemover();
        testeAtualizar();
    }

    private static void testeCriarProduto() throws SQLException{

        Produto prod1 = new Produto(1,"Notebook Samsung", 3523.00, 1, 1, TipoProduto.NAO_ISENTO);
        Produto prod2 = new ProdutoIsento(2,"Clean Architecture", "descricao", 102.90, 2, 5);
        Produto prod3 = new Produto(3,"Monitor Dell 27", "descricao", 1889.00, 3, 7, TipoProduto.NAO_ISENTO);

        try(Connection conn = new ConnectionFactory().conectar()){
            ProdutoDAO produtoDAO = new ProdutoDAO(conn);
            produtoDAO.criar(prod1);
            produtoDAO.criar(prod2);
            produtoDAO.criar(prod3);
        }
    }
    private static void testeListarProduto() throws SQLException {
        try(Connection conn = new ConnectionFactory().conectar()){
            ProdutoDAO produtoDAO = new ProdutoDAO(conn);
            List<Produto> listaDeProdutos = produtoDAO.consultar();
            listaDeProdutos.stream().forEach(lc -> System.out.println(lc));
        }
    }
    private static void testeRemover() throws SQLException{
        Produto prod1 = new Produto(14,"Notebook Samsung", 3523.00, 1, 19, TipoProduto.NAO_ISENTO);
        try(Connection conn = new ConnectionFactory().conectar()){
            ProdutoDAO produtoDAO = new ProdutoDAO(conn);
            produtoDAO.remover(prod1);
        }
    }
    private static void testeAtualizar() throws SQLException{
        Produto prod1 = new Produto(14,"Notebook", "teste",3523.00, 1, 19, TipoProduto.NAO_ISENTO);

        try(Connection conn = new ConnectionFactory().conectar()){
            ProdutoDAO produtoDAO = new ProdutoDAO(conn);
            produtoDAO.atualizar(prod1);
        }
    }
}
