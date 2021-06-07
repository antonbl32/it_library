import by.anton.dao.AuthorDAO;
import by.anton.dao.AuthorDAOImpl;
import by.anton.entity.Author;
import by.anton.entity.Book;
import by.anton.service.BookService;
import by.anton.service.BookServiceImpl;
import org.junit.Assert;

import java.beans.PropertyVetoException;

public class BookServiceImplTest {
    private BookService service;
    private AuthorDAO authorDAO;
    @org.junit.Test
    public void getBookById() throws PropertyVetoException {
        service = new BookServiceImpl();
        Book book=service.getBookById(2);
        Assert.assertNotNull(book);
        //Assert.assertTrue("Yes",book.getName().equalsIgnoreCase("Ночь в музее"));
    }
    @org.junit.Test
    public void testAuthor() throws PropertyVetoException {
        authorDAO=new AuthorDAOImpl();
        System.out.println(authorDAO.getAllAuthors());
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
