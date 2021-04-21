package by.anton.dao;

import by.anton.entity.Book;

import java.util.List;

public interface BookDAO {
    public Book getBookById(int id);
    public List<Book> getAllBooks();
    public void addBook(Book book);
    public void deleteBook(int id);
//    public User getUser(int id);
}
