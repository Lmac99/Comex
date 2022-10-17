package br.com.comex.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

    public DataSource dataSource;

    public ConnectionFactory() throws SQLException{
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        comboPooledDataSource.setUser("comex");
        comboPooledDataSource.setPassword("comex");
        comboPooledDataSource.setLoginTimeout(2);

        comboPooledDataSource.setMaxPoolSize(10);

        this.dataSource = comboPooledDataSource;
    }

    public Connection conectar() throws SQLException {
        return this.dataSource.getConnection();
    }
}