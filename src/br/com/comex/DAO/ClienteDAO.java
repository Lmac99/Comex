package br.com.comex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.EstadoClienteSigla;

public class ClienteDAO {
    private Connection conn;

    public ClienteDAO(Connection connection){
        this.conn = connection;
    }

    public void criar(Cliente cliente) throws SQLException{
        this.conn.setAutoCommit(false);
        String query = "INSERT INTO comex.cliente (NOME, CPF, TELEFONE, RUA, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, UF) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getRua());
            stmt.setString(5, cliente.getNumero());
            stmt.setString(6, cliente.getComplemento());
            stmt.setString(7, cliente.getBairro());
            stmt.setString(8, cliente.getCidade());
            stmt.setString(9, cliente.getEstado().name());

            stmt.execute();

            System.out.println("Linhas criadas =  " + stmt.getUpdateCount());

            conn.commit();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ROLLBACK INICIADO");
            conn.rollback();
        }
    }

    public void remover(int id) throws SQLException{
        this.conn.setAutoCommit(false);
        String query = "DELETE FROM comex.cliente WHERE ID = ?";
        //String query = "DELETE FROM comex.cliente WHERE ID = ?"; -> cliente.getId();

        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setLong(1, id);
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
    public void atualizar(Cliente cliente, int id) throws SQLException{
        this.conn.setAutoCommit(false);
        //NOME, CPF, TELEFONE, RUA, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, UF
        String query = "UPDATE comex.cliente SET NOME = ?, CPF = ?, TELEFONE = ?, RUA = ?, NUMERO = ?, COMPLEMENTO = ?, BAIRRO = ?, CIDADE = ?, UF = ? WHERE ID = ?";
        
        
        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getRua());
            stmt.setString(5, cliente.getNumero());
            stmt.setString(6, cliente.getComplemento());
            stmt.setString(7, cliente.getBairro());
            stmt.setString(8, cliente.getCidade());
            stmt.setString(9, cliente.getEstado().name());
            stmt.setInt(10, id);

            stmt.executeUpdate();

            System.out.println("Linhas atualizadas =  " + stmt.getUpdateCount());

            conn.commit();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ROLLBACK INICIADO");
            conn.rollback();
        }
    }

    public List<Cliente> consultar() throws SQLException{
        List<Cliente> clientes = new ArrayList<Cliente>();
        
        String query = "SELECT * FROM comex.cliente";
        try(PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.execute();
            try(ResultSet rst = stmt.getResultSet()){
                while(rst.next()){
                    String complemento = rst.getString(7) == null ? "sem complemento" : rst.getString(3);
                    try(Connection conn = new ConnectionFactory().conectar()){
                        Cliente cliente = new Cliente(rst.getInt(1), rst.getString(2), rst.getString(3),
                        rst.getString(4),rst.getString(5),
                        rst.getString(6),complemento,rst.getString(8),rst.getString(9), EstadoClienteSigla.valueOf(rst.getString(10)));
                        clientes.add(cliente);
                    }
                }
            }
        }
        return clientes;
    }
}
