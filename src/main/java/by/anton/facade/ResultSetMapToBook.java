package by.anton.facade;

import by.anton.entity.*;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
@NoArgsConstructor
public class ResultSetMapToBook {
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
}
