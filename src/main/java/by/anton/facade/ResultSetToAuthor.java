package by.anton.facade;

import by.anton.entity.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetToAuthor {
    public Author mapResultSetToAuthor(ResultSet resultSet) throws SQLException {
        try {
            return new Author(resultSet.getInt("author_id")
                    , resultSet.getString("author_name")
                    , resultSet.getString("author_soname"));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
