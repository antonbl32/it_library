package by.anton.service;

import by.anton.dao.BookDAO;
import by.anton.dao.BookDAOImpl;
import by.anton.entity.Book;

import java.beans.PropertyVetoException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    public BookServiceImpl() throws PropertyVetoException {
        this.bookDAO = new BookDAOImpl();
    }

    @Override
    public Book getBookById(int id) {
        return bookDAO.getBookById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }

    @Override
    public List<Book> sortBooksByName(List<Book> list) {
        return list.stream().sorted(Comparator.comparing(Book::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> sortBooksByAuthor(List<Book> list) {
        return list.stream().sorted(Comparator.comparing(book->book.getAuthor().getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> sortBooksByGenre(List<Book> list) {
        return list.stream().sorted(Comparator.comparing(book->book.getGenre().getType()))
                .collect(Collectors.toList());
    }
}
