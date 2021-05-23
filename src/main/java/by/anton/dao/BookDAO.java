package by.anton.dao;

import by.anton.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    public Book getBookById(int id);
    public List<Book> getAllBooks();
    public void addBook(Book book);
    public void deleteBook(int id);
}
