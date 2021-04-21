package by.anton.dao;

import by.anton.connection.MysqlConnection;
import by.anton.entity.*;
import lombok.Data;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Data
public class BookDAOImpl implements BookDAO {
    MysqlConnection db;

    public BookDAOImpl() throws PropertyVetoException {
    this.db =new MysqlConnection();
    }

    @Override
    public Book getBookById(int id) {
        String sql = "select * from book b JOIN author a ON a.author_id=b.book_author" +
                "            JOIN genre g on g.genre_id=b.book_genre JOIN user u on u.user_id=b.book_user " +
                "where b.book_id=" + id;
        ResultSet resultSet = null;
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            return this.mapResultSetToBook(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public Book mapResultSetToBook(ResultSet resultSet) throws SQLException {
        try {
            return new Book(resultSet.getInt("book_id"),
                    resultSet.getString("book_name"),
                    new Author(resultSet.getInt("author_id"),
                    resultSet.getString("author_name"),
                    resultSet.getString("author_soname")),
                    new Genre(resultSet.getInt("genre_id"),
                            resultSet.getString("genre_type"),
                            resultSet.getString("genre_desc")),
                    new User(resultSet.getInt("user_id"),
                            resultSet.getString("user_name"),
                            resultSet.getString("user_password"),
                            new Role(resultSet.getInt("role_id"),
                                    resultSet.getInt("role_admin"),
                                    resultSet.getInt("role_user"))));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws PropertyVetoException {
        BookDAOImpl b = new BookDAOImpl();
        System.out.println(b.getAllBooks());
        System.out.println(b.getBookById(1));
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "select * from book b JOIN author a ON a.author_id=b.book_author " +
                "JOIN genre g on g.genre_id=b.book_genre JOIN user u on u.user_id=b.book_user " +
                "JOIN role r on r.role_id=u.user_role;";
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(this.mapResultSetToBook(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void addBook(Book book) {
        String sql = "insert into book (book_name, book_author_id, book_user_id, book_genre) VALUES" +
                "('" + book.getName() + "'," + book.getAuthor().getId() + "," + book.getUser().getId() + ",";
    }

    @Override
    public void deleteBook(int id) {

    }
}
