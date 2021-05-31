package by.anton.facade;

import by.anton.entity.Role;
import by.anton.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetToUser {
    public User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        try {
            return new User(resultSet.getInt("user_id"),
                    resultSet.getString("user_name"),
                    resultSet.getString("user_password"),
                    new Role(resultSet.getInt("role_id"),
                            resultSet.getInt("role_admin"),
                            resultSet.getInt("role_user")));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
