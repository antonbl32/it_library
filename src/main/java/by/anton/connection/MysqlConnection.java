package by.anton.connection;

import lombok.Data;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
@Data
public class MysqlConnection implements Closeable {

   private Connection connection = null;
   private Statement statement = null;

    public MysqlConnection() throws ClassNotFoundException {
        System.out.println("Registering JDBC driver...");

        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Creating database connection...");
        try {
            this.connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("Executing statement...");
        try {
            this.statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        try {
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * JDBC Driver and database url
     */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3307/freeit?serverTimezone=Europe/Moscow";

    /**
     * User and Password
     */
    static final String USER = "root";
    static final String PASSWORD = "321000";


}
