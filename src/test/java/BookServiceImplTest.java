import by.anton.entity.Book;
import by.anton.service.BookService;
import by.anton.service.BookServiceImpl;
import org.junit.Assert;

import java.beans.PropertyVetoException;

public class BookServiceImplTest {
    BookService service;

    @org.junit.Test
    public void getBookById() throws PropertyVetoException {
        service = new BookServiceImpl();
        Book book=service.getBookById(2);
        Assert.assertTrue("Yes",book.getName().equalsIgnoreCase("Ночь в музее"));
    }

    @org.junit.Test
    public void getAllBooks() {

    }

    @org.junit.Test
    public void addBook() {
    }

    @org.junit.Test
    public void deleteBook() {
    }
}