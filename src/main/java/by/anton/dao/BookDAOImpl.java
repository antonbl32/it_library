package by.anton.dao;

import by.anton.connection.MysqlConnection;
import by.anton.entity.Author;
import by.anton.entity.Book;
import by.anton.entity.Genre;
import lombok.Data;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Data
public class BookDAOImpl implements BookDAO {
    MysqlConnection db;

    {
        try {
            db = new MysqlConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public Book getBookById(int id) {
        String sql = "select * from book b JOIN author a ON a.author_id=b.book_author" +
                " JOIN genre g on g.genre_id=b.book_genre where b.book_id=" + id;
        ResultSet resultSet = null;
        try (Connection connection=db.getConnection()) {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            return this.mapResultSetToBook(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
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
                    resultSet.getString("book_name"), new Author(resultSet.getInt("author_id"),
                    resultSet.getString("author_name"),
                    resultSet.getString("author_soname")),
                    new Genre(resultSet.getInt("genre_id"),
                            resultSet.getString("genre_type"),
                            resultSet.getString("genre_desc")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        BookDAOImpl b = new BookDAOImpl();
        System.out.println(b.getAllBooks());
        System.out.println(b.getBookById(1));
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "select * from book b JOIN author a ON a.author_id=b.book_author " +
                "JOIN genre g on g.genre_id=b.book_genre;";
        try (Connection connection=db.getConnection()) {
            Statement statement = connection.createStatement();
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
        String sql = "INSERT INTO book ('book_id','book_name','book_author_id)" +
                "VALUES()";
    }

    @Override
    public void deleteBook(int id) {

    }
}
