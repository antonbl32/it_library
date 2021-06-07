package by.anton.facade;

import by.anton.entity.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetToGenre {
    public Genre mapResultSetToGenre(ResultSet resultSet) throws SQLException {
        try {
            return new Genre(resultSet.getInt("genre_id")
                    , resultSet.getString("genre_type")
                    , resultSet.getString("genre_desc"));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
