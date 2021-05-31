package by.anton.dao;

import by.anton.connection.MysqlConnection;
import by.anton.entity.Genre;
import by.anton.exception.NoSuchAuthorException;
import by.anton.exception.NoSuchGenreException;
import by.anton.facade.ResultSetToGenre;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenreDAOImpl implements GenreDAO {
    private MysqlConnection db;

    private ResultSetToGenre mapTo = new ResultSetToGenre();
    private static final Logger log = LogManager.getLogger(GenreDAOImpl.class);

    public GenreDAOImpl() {
        this.db = MysqlConnection.getInstance();
    }

    @Override
    public Genre getGenreById(int id) {
        String sql = "select * from genre a where a.genre_id=" + id;
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (!resultSet.next()) {
                throw new NoSuchAuthorException("Genre with id+" + id + " not found.");
            }
            log.info("Get genre with id " + id);
            return mapTo.mapResultSetToGenre(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchAuthorException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Genre> getAllGenres() {
        List<Genre> genres = new ArrayList<>();
        String sql = "select * from genre;";
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (!resultSet.next()) {
                throw new NoSuchGenreException("No genres found");
            }
            log.info("Get all genres");
            while (resultSet.next()) {
                genres.add(mapTo.mapResultSetToGenre(resultSet));
            }
            return genres;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchGenreException e) {
            e.printStackTrace();
        }
        return null;
    }

}
