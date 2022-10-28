package br.com.comex.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

    public DataSource dataSource;

    public ConnectionFactory() throws SQLException{
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Logger.getLogger("com.mchange.v2.c3p0").setLevel(Level.WARNING);

        comboPooledDataSource.setJdbcUrl("jdbc:oracle:thin:@comex:1522:xe");
        comboPooledDataSource.setUser("SYSTEM");
        comboPooledDataSource.setPassword("admin");
        comboPooledDataSource.setLoginTimeout(2);

        comboPooledDataSource.setMaxPoolSize(10);

        this.dataSource = comboPooledDataSource;
    }

    public Connection conectar() throws SQLException {
        return this.dataSource.getConnection();
    }
}
