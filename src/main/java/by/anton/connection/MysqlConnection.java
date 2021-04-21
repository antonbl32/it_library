package by.anton.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class MysqlConnection implements Closeable {
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

    @Override
    public void close() throws IOException {
        ds.close();
    }
}
