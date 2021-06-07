package by.anton.service;


import by.anton.dao.*;
import by.anton.entity.Author;
import by.anton.entity.Book;
import by.anton.entity.Genre;
import by.anton.entity.User;
import by.anton.security.SecurityUser;

import java.beans.PropertyVetoException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;
    private GenreDAO genreDAO;
    private AuthorDAO authorDAO;
    private SecurityUser securityUser;

    public BookServiceImpl() throws PropertyVetoException {
        this.bookDAO = new BookDAOImpl();
        this.authorDAO=new AuthorDAOImpl();
        this.genreDAO=new GenreDAOImpl();
        this.securityUser=new SecurityUser();
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
    @Override
    public void createBook(){
        Scanner sc=new Scanner(System.in);
        Scanner sc1=new Scanner(System.in);
        System.out.println("Введите название книги");
        String name=sc.nextLine();
        System.out.println("Введите id автора");
        System.out.println(authorDAO.getAllAuthors());
        int author=sc1.nextInt();
        System.out.println("Введите id жанра");
        System.out.println(genreDAO.getAllGenres());
        int genre=sc1.nextInt();
        User user=securityUser.getUserByUUID();
        Book book=new Book(name,authorDAO.getAuthorById(author),genreDAO.getGenreById(genre),user);
        addBook(book);
        System.out.println("Книга добавлена");

    }
}
