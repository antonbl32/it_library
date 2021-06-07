package by.anton.dao;

import by.anton.entity.Author;

import java.util.List;

public interface AuthorDAO {
    List<Author> getAllAuthors();
    Author getAuthorById(int id);
}
