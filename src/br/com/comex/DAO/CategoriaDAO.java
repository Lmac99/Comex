package br.com.comex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.StatusCategoria;

public class CategoriaDAO {
    private Connection conn;

    public CategoriaDAO(Connection connection){
        this.conn = connection;
    }

    public void criarCategoria(Categoria categoria) throws SQLException{
        this.conn.setAutoCommit(false);
        String query = "INSERT INTO comex.categoria (NOME, STATUS) VALUES (?, ?)";

        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getStatus().name());

            stmt.execute();

            System.out.println("Linhas criadas =  " + stmt.getUpdateCount());

            conn.commit();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ROLLBACK INICIADO");
            conn.rollback();
        }
    }
    // Adicionar dois parâmetros, um com a coluna que vai ser validada e outra com o valor 
    public void removerCategoria(String valor) throws SQLException{
        this.conn.setAutoCommit(false);
        String query = "DELETE FROM comex.categoria WHERE STATUS = ?";

        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setString(1, valor);
            stmt.executeUpdate();

            Integer linhasModificadas = stmt.getUpdateCount();
            
            conn.commit();
            System.out.println("Linhas removidas "+linhasModificadas);


        }catch(SQLException e){
            System.out.println(e);
            System.out.println("ROLLBACK INICIADO");
            conn.rollback();
        }
    }
    public void atualizarCategoria(Categoria categoria) throws SQLException{
        this.conn.setAutoCommit(false);
        //String query = "UPDATE comex.categoria SET NOME = ? WHERE NOME = ?";
        //String query = "UPDATE comex.categoria SET ? = ? WHERE ? = ?";
        String query = "UPDATE comex.categoria SET NOME = ?, STATUS = ? WHERE id = ?";
        
        
        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getStatus().name());
            stmt.setLong(3, categoria.getId());

            stmt.executeUpdate();

            System.out.println("Linhas atualizadas =  " + stmt.getUpdateCount());

            conn.commit();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ROLLBACK INICIADO");
            conn.rollback();
        }
    }

    public List<Categoria> consultaCategorias() throws SQLException{
        List<Categoria> categorias = new ArrayList<Categoria>();
        
        String query = "SELECT ID, NOME, STATUS FROM comex.categoria";

        try(PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.execute();
            try(ResultSet rst = stmt.getResultSet()){
                while(rst.next()){
                    //System.out.println(rst.getInt(1)); <- comando para checar o id
                    Categoria cat = new Categoria(rst.getInt(1), rst.getString(2), StatusCategoria.valueOf(rst.getString(3)));
                    categorias.add(cat);
                }
            }
        }
        return categorias;
    }

    public Categoria consultaCategoria(int id) throws SQLException{
        
        String query = "SELECT ID, NOME, STATUS FROM comex.categoria WHERE ID = ?";

        try(PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.setInt(1, id);
            stmt.execute();
            try(ResultSet rst = stmt.getResultSet()){
                while(rst.next()){
                    Categoria cat = new Categoria(rst.getInt(1), rst.getString(2), StatusCategoria.valueOf(rst.getString(3)));
                    return cat;
                }
            }
        }
        return null;
    }
}
