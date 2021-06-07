package by.anton.dao;

import by.anton.entity.Genre;

import java.util.List;

public interface GenreDAO {
    List<Genre> getAllGenres();
    Genre getGenreById(int id);
}
