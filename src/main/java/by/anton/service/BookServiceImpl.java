package by.anton.service;

import by.anton.dao.BookDAO;
import by.anton.dao.BookDAOImpl;
import by.anton.entity.Book;

import java.beans.PropertyVetoException;
import java.util.List;

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
}
