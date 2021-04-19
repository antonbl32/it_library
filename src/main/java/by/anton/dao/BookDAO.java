package by.anton.dao;

import by.anton.entity.Author;
import by.anton.entity.Book;
import by.anton.entity.Genre;
import by.anton.entity.User;

import java.util.List;

public interface BookDAO {
    public Book getBookById(int id);
    public List<Book> getAllBooks();
    public void addBook(Book book);
    public void deleteBook(int id);
    public Genre getGenre(int id);
    public Author getAuthor(int id);
//    public User getUser(int id);
}
