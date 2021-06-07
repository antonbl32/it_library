package by.anton.dao;

import by.anton.entity.Book;

import java.util.List;

public interface BookDAO {

    Book getBookById(int id);

    List<Book> getAllBooks();

    void addBook(Book book);

    void deleteBook(int id);
}
