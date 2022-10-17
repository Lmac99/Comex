package br.com.comex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.ItemPedido;
import br.com.comex.modelo.TipoDesconto;

public class ItemDePedidoDAO {
    private Connection conn;

    public ItemDePedidoDAO(Connection connection){
        this.conn = connection;
    }

    public void criar(ItemPedido itemPedido) throws SQLException{
        this.conn.setAutoCommit(false);
        String query = "INSERT INTO comex.item_pedido (PRECO_UNITARIO, QUANTIDADE, PRODUTO_ID, PEDIDO_ID, DESCONTO, TIPO_DESCONTO) VALUES (?, ?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setDouble(1, itemPedido.getPreco());
            stmt.setInt(2, itemPedido.getQuantidade());
            stmt.setLong(3, itemPedido.getProduto());
            stmt.setLong(4, itemPedido.getIdPedido());
            stmt.setDouble(5, itemPedido.getDesconto());
            stmt.setString(6, itemPedido.getTipoDesconto().name());

            stmt.execute();

            System.out.println("Linhas criadas =  " + stmt.getUpdateCount());

            conn.commit();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ROLLBACK INICIADO");
            conn.rollback();
        }
    }

    public void remover(ItemPedido itemPedido) throws SQLException{
        this.conn.setAutoCommit(false);
        String query = "DELETE FROM comex.item_pedido WHERE ID = ?";
        //String query = "DELETE FROM comex.itemPedido WHERE ID = ?"; -> itemPedido.getId();

        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setLong(1, itemPedido.getId());
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
    public void atualizar(ItemPedido itemPedido) throws SQLException{
        this.conn.setAutoCommit(false);
        String query = "UPDATE comex.item_pedido SET PRECO_UNITARIO = ?, QUANTIDADE = ?, PRODUTO_ID = ?, PEDIDO_ID = ?, DESCONTO = ?, TIPO_DESCONTO = ? WHERE ID = ?";
        
        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setDouble(1, itemPedido.getPreco());
            stmt.setInt(2, itemPedido.getQuantidade());
            stmt.setLong(3, itemPedido.getProduto());
            stmt.setLong(4, itemPedido.getIdPedido());
            stmt.setDouble(5, itemPedido.getDesconto());
            stmt.setString(6, itemPedido.getTipoDesconto().name());
            stmt.setLong(7, itemPedido.getId());

            stmt.executeUpdate();

            System.out.println("Linhas atualizadas =  " + stmt.getUpdateCount());

            conn.commit();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ROLLBACK INICIADO");
            conn.rollback();
        }
    }

    public List<ItemPedido> consultar() throws SQLException{
        List<ItemPedido> itemPedidos = new ArrayList<ItemPedido>();
        
        String query = "SELECT * FROM comex.item_pedido";
        try(PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.execute();
            
            try(ResultSet rst = stmt.getResultSet()){
                while(rst.next()){
                        ItemPedido prod = new ItemPedido(
                            rst.getLong(1),
                            rst.getDouble(2), rst.getInt(3), 
                            rst.getLong(4), rst.getLong(5), 
                            TipoDesconto.valueOf(rst.getString(7)));
                        itemPedidos.add(prod);
                    }
                }
            }
        return itemPedidos;
    }
}
