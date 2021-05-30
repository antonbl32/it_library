package by.anton.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class MysqlConnection {
    private static MysqlConnection instance;
    private static final ComboPooledDataSource ds = new ComboPooledDataSource();
    private static final Properties properties = new Properties();

    private MysqlConnection() {
    }

    public static MysqlConnection getInstance() {
        if (instance == null) {
            try {
                instance = new MysqlConnection();
                FileInputStream fis = new FileInputStream("src/main/resources/db.properties");
                properties.load(fis);
                ds.setDriverClass(properties.getProperty("db.driver"));
                ds.setUser(properties.getProperty("db.user"));
                ds.setPassword(properties.getProperty("db.password"));
                ds.setJdbcUrl(properties.getProperty("db.url"));
            } catch (IOException | PropertyVetoException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
