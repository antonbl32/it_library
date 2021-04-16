package by.anton.service;

import by.anton.dao.BookDAO;
import by.anton.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;
    @Transactional
    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }
    @Transactional
    @Override
    public void deleteBook(Book book) {
        bookDAO.deleteBook(book);
    }
    @Transactional
    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }
    @Transactional
    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }
    @Transactional
    @Override
    public Book getBookById(int id) {
        return bookDAO.getBookById(id);
    }
}
