package by.anton.dao;

import by.anton.connection.MysqlConnection;
import by.anton.entity.Author;
import by.anton.entity.User;
import by.anton.exception.NoSuchAuthorException;
import by.anton.exception.NoSuchUserException;
import by.anton.facade.ResultSetToAuthor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {
    private MysqlConnection db;
    private ResultSetToAuthor mapTo = new ResultSetToAuthor();
    private static final Logger log = LogManager.getLogger(AuthorDAOImpl.class);

    public AuthorDAOImpl() throws PropertyVetoException {
        this.db = MysqlConnection.getInstance();
    }
    @Override
    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        String sql = "select * from author;";
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (!resultSet.next()) {
                throw new NoSuchAuthorException("No authors found");
            }
            log.info("Get all authors");
            while (resultSet.next()) {
                authors.add(mapTo.mapResultSetToAuthor(resultSet));
            }
            return authors;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchAuthorException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Author getAuthorById(int id) {
        String sql = "select * from author a where a.author_id=" + id;
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (!resultSet.next()) {
                throw new NoSuchAuthorException("User with id+" + id + " not found.");
            }
            log.info("Get user with id " + id);
            return mapTo.mapResultSetToAuthor(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchAuthorException e) {
            e.printStackTrace();
        }
        return null;
    }

}
