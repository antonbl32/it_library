package by.anton.controller;

import by.anton.entity.Book;
import by.anton.exceptionhandler.NoBookFound;
import by.anton.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryConrtoller {
    @Autowired
    private BookService bookService;

    /**
     * @return List all books
     */
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    /**
     * @param book - from body request book add to repository
     * @return book this id, after save to repository
     */
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        if (book == null) {
            throw new NoBookFound("Not book for add");
        }
        bookService.addBook(book);
        return book;
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return book;
    }

    @DeleteMapping("/books")
    public String deleteEmployeeById(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            throw new NoBookFound("Not found book with id " + id);
        }
        bookService.deleteBook(book);
        return "Book with id=" + id + " was deleted.";
    }


}
