package by.anton.service;

import by.anton.entity.Book;
import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();

    public void deleteBook(Book book);

    public void updateBook(Book book);

    public void addBook(Book book);

    public Book getBookById(int id);
}
