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

            System.out.println("Number of rows updated in database =  " + stmt.getUpdateCount());

            conn.commit();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ROLLBACK INICIADO");
            conn.rollback();
        }
    }
    public void removerCategoria(){}
    public void atualizarCategoria(){}

    public List<Categoria> consultaCategoria() throws SQLException{
        List<Categoria> categorias = new ArrayList<Categoria>();
        
        String query = "SELECT ID, NOME, STATUS FROM comex.categoria";

        try(PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.execute();
            try(ResultSet rst = stmt.getResultSet()){
                while(rst.next()){
                    System.out.println(rst.getInt(1));
                    Categoria cat = new Categoria(rst.getInt(1), rst.getString(2), StatusCategoria.valueOf(rst.getString(3)));
                    categorias.add(cat);
                }
            }
        }
        return categorias;
    }
}
