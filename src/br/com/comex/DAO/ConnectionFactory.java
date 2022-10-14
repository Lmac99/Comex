package br.com.comex.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "comex", "comex");
    }
}
