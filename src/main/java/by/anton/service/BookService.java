package by.anton.service;

import by.anton.entity.Book;

import java.util.List;

public interface BookService {
    Book getBookById(int id);
    List<Book> getAllBooks();
    void addBook(Book book);
    void deleteBook(int id);
}
