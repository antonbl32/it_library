package by.anton.dao;

import by.anton.connection.MysqlConnection;
import by.anton.entity.User;
import by.anton.exception.NoSuchUserException;
import by.anton.facade.ResultSetToUser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private MysqlConnection db;
    private ResultSetToUser mapTo = new ResultSetToUser();
    private static final Logger log = LogManager.getLogger(BookDAOImpl.class);

    public UserDAOImpl() throws PropertyVetoException {
        this.db = new MysqlConnection();
    }

    @Override
    public User getUserById(int id) {
        String sql = "select * from user u JOIN role r  ON u.user_role_id=r.role_id where u.user_id=" + id;
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (!resultSet.next()) {
                throw new NoSuchUserException("User with id+" + id + " not found.");
            }
            log.info("Get user with id " + id);
            return mapTo.mapResultSetToUser(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchUserException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "select * from user u JOIN role r  ON u.user_role_id=r.role_id;";
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (!resultSet.next()) {
                throw new NoSuchUserException("No users found");
            }
            log.info("Get all users");
            while (resultSet.next()) {
                users.add(mapTo.mapResultSetToUser(resultSet));
            }
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchUserException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user u (user_id,user_name,user_password,user_role_id) VALUES" +
                "(default,'" + user.getName() + "'," + user.getPassword() + "," + user.getRole().getId() + ";)";
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
            log.info("Add user with name " + user.getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        String sql = "select user_id from user where user_id=" + id + ";";
        String sqlForDelete = "delete from user where user_id=" + id + ";";
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                statement.execute(sqlForDelete);
                log.info("User with id " + id + " deleted");
            } else {
                throw new NoSuchUserException("User with id " + id + " not found");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchUserException e) {
            e.printStackTrace();
        }
    }
}
