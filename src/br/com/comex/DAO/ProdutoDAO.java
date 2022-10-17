package br.com.comex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.TipoProduto;

public class ProdutoDAO {
    private Connection conn;

    public ProdutoDAO(Connection connection){
        this.conn = connection;
    }

    public void criar(Produto produto) throws SQLException{
        this.conn.setAutoCommit(false);
        String query = "INSERT INTO comex.produto (NOME, DESCRICAO, PRECO_UNITARIO, QUANTIDADE_ESTOQUE, CATEGORIA_ID, TIPO) VALUES (?, ?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setLong(5, produto.getCategoria().getId());
            stmt.setString(6, produto.getTipo().name());

            stmt.execute();

            System.out.println("Linhas criadas =  " + stmt.getUpdateCount());

            conn.commit();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ROLLBACK INICIADO");
            conn.rollback();
        }
    }

    public void remover(Produto produto) throws SQLException{
        this.conn.setAutoCommit(false);
        String query = "DELETE FROM comex.produto WHERE ID = ?";
        //String query = "DELETE FROM comex.produto WHERE ID = ?"; -> produto.getId();

        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setLong(1, produto.getId());
            stmt.execute();

            Integer linhasModificadas = stmt.getUpdateCount();
            
            conn.commit();
            System.out.println("Linhas removidas "+linhasModificadas);


        }catch(SQLException e){
            System.out.println(e);
            System.out.println("ROLLBACK INICIADO");
            conn.rollback();
        }
    }
    public void atualizar(Produto produto) throws SQLException{
        this.conn.setAutoCommit(false);
        String query = "UPDATE comex.produto SET NOME = ?, DESCRICAO = ?, PRECO_UNITARIO = ?, QUANTIDADE_ESTOQUE = ?, CATEGORIA_ID = ?, TIPO = ? WHERE ID = ?";
        
        
        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setLong(5, produto.getCategoria().getId());
            stmt.setString(6, produto.getTipo().name());
            stmt.setLong(7, produto.getId());

            stmt.executeUpdate();

            System.out.println("Linhas atualizadas =  " + stmt.getUpdateCount());

            conn.commit();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ROLLBACK INICIADO");
            conn.rollback();
        }
    }

    public List<Produto> consultar() throws SQLException{
        List<Produto> produtos = new ArrayList<Produto>();
        
        String query = "SELECT ID, NOME, DESCRICAO, PRECO_UNITARIO, QUANTIDADE_ESTOQUE, CATEGORIA_ID, TIPO FROM comex.produto";
        try(PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.execute();
            
            try(ResultSet rst = stmt.getResultSet()){
                while(rst.next()){
                    String descricao = rst.getString(3) == null ? "sem descricao" : rst.getString(3);
                    try(Connection conn = new ConnectionFactory().conectar()){
                        CategoriaDAO categoriaDAO = new CategoriaDAO(conn);
                        Categoria cat = categoriaDAO.consultaCategoria(rst.getInt(6));
                        Produto prod = new Produto(
                            
                            rst.getInt(1), rst.getString(2), descricao, 
                            rst.getDouble(4), rst.getInt(5), cat, 
                            TipoProduto.valueOf(rst.getString(7)));
                        produtos.add(prod);
                    }
                }
            }
        }
        return produtos;
    }
}
