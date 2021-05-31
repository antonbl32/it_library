package by.anton.dao;

import by.anton.connection.MysqlConnection;
import by.anton.entity.Book;
import by.anton.exception.NoSuchBookException;
import by.anton.facade.ResultSetMapToBook;
import lombok.Data;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Data
public class BookDAOImpl implements BookDAO {
    private MysqlConnection db;
    private ResultSetMapToBook mapTo = new ResultSetMapToBook();
    private static final Logger log = LogManager.getLogger(BookDAOImpl.class);

    public BookDAOImpl() {
        this.db = MysqlConnection.getInstance();
    }

    @Override
    public Book getBookById(int id) {
        String sql = "select * from book b JOIN author a ON a.author_id=b.book_author_id" +
                "            JOIN genre g on g.genre_id=b.book_genre JOIN user u on u.user_id=b.book_user_id " +
                " JOIN role r on u.user_role_id=r.role_id where b.book_id=" + id;
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (!resultSet.next()) {
                throw new NoSuchBookException("Book with id+" + id + " not found.");
            }
            log.info("Get book with id " + id);
            return mapTo.mapResultSetToBook(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchBookException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "select * from book b JOIN author a ON a.author_id=b.book_author_id " +
                "JOIN genre g on g.genre_id=b.book_genre JOIN user u on u.user_id=b.book_user_id " +
                "JOIN role r on r.role_id=u.user_role_id;";
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(mapTo.mapResultSetToBook(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void addBook(Book book) {
        String sql = "insert into book (book_id,book_name, book_author_id, book_user_id, book_genre) VALUES" +
                "(default, '" + book.getName() + "'," + book.getAuthor().getId() + "," + book.getUser().getId() + ","
                + book.getGenre().getId()+");";
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
            log.info("Add book with id " + book.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteBook(int id) {
        String sql = "select book.id from book where book.id=" + id + ";";
        String sqlForDelete = "delete from book where book.id=" + id + ";";
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                statement.execute(sqlForDelete);
                log.info("book with id " + id + " deleted");
            } else {
                throw new NoSuchBookException("Book with id " + id + " not found");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchBookException e) {
            e.printStackTrace();
        }
    }
}
