package by.anton.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.Data;
import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class MysqlConnection {
    private ComboPooledDataSource ds = new ComboPooledDataSource();
    public MysqlConnection() throws PropertyVetoException{
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
        ds.setUser("root");
        ds.setPassword("321000");
        ds.setJdbcUrl("jdbc:mysql://localhost:3307/freeit?serverTimezone=Europe/Moscow");
    }
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
