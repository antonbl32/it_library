package by.anton.dao;

import by.anton.entity.Book;

import java.util.List;

public interface BookDAO {

    public List<Book> getAllBooks();
    public void deleteBook(Book book);
    public void updateBook(Book book);
    public void addBook(Book book);
    public Book getBookById(int id);

}
