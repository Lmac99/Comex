package br.com.comex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.Pedido;

public class PedidoDAO {
    private Connection conn;

    public PedidoDAO(Connection connection){
        this.conn = connection;
    }

    public void criar(Pedido pedido) throws SQLException{
        this.conn.setAutoCommit(false);
        String query = "INSERT INTO comex.pedido (DATA, CLIENTE_ID) VALUES (?, ?)";

        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setDate(1, new java.sql.Date(pedido.getData().getTime()));
            stmt.setLong(2, pedido.getClienteId());

            stmt.execute();

            System.out.println("Linhas criadas =  " + stmt.getUpdateCount());

            conn.commit();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ROLLBACK INICIADO");
            conn.rollback();
        }
    }

    public void remover(Pedido pedido) throws SQLException{
        this.conn.setAutoCommit(false);
        String query = "DELETE FROM comex.pedido WHERE ID = ?";
        //String query = "DELETE FROM comex.pedido WHERE ID = ?"; -> pedido.getId();

        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setLong(1, pedido.getId());
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
    public void atualizar(Pedido pedido) throws SQLException{
        this.conn.setAutoCommit(false);
        String query = "UPDATE comex.pedido SET DATA = ?, CLIENTE_ID = ? WHERE ID = ?";
        
        
        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setDate(1, new java.sql.Date(pedido.getData().getTime()));
            stmt.setLong(2, pedido.getClienteId());
            stmt.setLong(3, pedido.getId());

            stmt.executeUpdate();

            System.out.println("Linhas atualizadas =  " + stmt.getUpdateCount());

            conn.commit();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ROLLBACK INICIADO");
            conn.rollback();
        }
    }

    public List<Pedido> consultar() throws SQLException{
        List<Pedido> pedidos = new ArrayList<Pedido>();
        
        String query = "SELECT * FROM comex.pedido";
        try(PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.execute();
            try(ResultSet rst = stmt.getResultSet()){
                while(rst.next()){
                    try(Connection conn = new ConnectionFactory().conectar()){
                        Pedido pedido = new Pedido(rst.getLong(1), rst.getDate(2), rst.getLong(3));
                        pedidos.add(pedido);
                    }
                }
            }
        }
        return pedidos;
    }
}
