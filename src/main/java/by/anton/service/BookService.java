package by.anton.service;

import by.anton.entity.Book;

import java.util.List;

public interface BookService {
    Book getBookById(int id);

    List<Book> getAllBooks();

    void addBook(Book book);

    void deleteBook(int id);

    List<Book> sortBooksByName(List<Book> list);

    List<Book> sortBooksByAuthor(List<Book> list);

    List<Book> sortBooksByGenre(List<Book> list);
}
