package by.anton.dao;

import by.anton.connection.MysqlConnection;
import by.anton.entity.Author;
import by.anton.entity.Book;
import by.anton.entity.Genre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private MysqlConnection db=new MysqlConnection();
    private Statement statement=db.getStatement();

    @Override
    public Genre getGenre(int id) {
        String sqlAuthor = "SELECT * FROM genre where genre_id="+id;
        try {
            ResultSet resultSet=statement.executeQuery(sqlAuthor);
            return new Genre(resultSet.getInt("genre_id"),
                    resultSet.getString("genre_type"),
                    resultSet.getString("genre_desc"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new Genre();
    }

    @Override
    public Author getAuthor(int id) {
        String sqlAuthor = "SELECT * FROM author where author_id="+id;
        try {
            ResultSet resultSet=statement.executeQuery(sqlAuthor);
            return new Author(resultSet.getInt("author_id"),
                    resultSet.getString("author_name"),
                    resultSet.getString("author_soname"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new Author();
    }

//    @Override
//    public User getUser(int id) {
//        return new User();
//    }

    public BookDAOImpl() throws ClassNotFoundException {
    }

    @Override
    public Book getBookById(int id) {
        String sql = "select * from book b JOIN author a ON a.author_id=b.book_author\n" +
                "JOIN genre g on g.genre_id=b.book_genre where b.book_id="+id;

        try {
            ResultSet resultSet = statement.executeQuery(sql);
            return new Book(resultSet.getInt("book_id"),
                    resultSet.getString("book_name"),new Author(resultSet.getInt("author_id"),
                    resultSet.getString("author_name"),
                    resultSet.getString("author_soname")),
                    new Genre(resultSet.getInt("genre_id"),
                            resultSet.getString("genre_type"),
                            resultSet.getString("genre_desc")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return new Book();
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> list=new ArrayList<>();
        String sql = "select * from book b JOIN author a ON a.author_id=b.book_author " +
                "JOIN genre g on g.genre_id=b.book_genre;";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                list.add(new Book(resultSet.getInt("book_id"),
                        resultSet.getString("book_name"),new Author(resultSet.getInt("author_id"),
                        resultSet.getString("author_name"),
                        resultSet.getString("author_soname")),
                        new Genre(resultSet.getInt("genre_id"),
                                resultSet.getString("genre_type"),
                                resultSet.getString("genre_desc"))));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public void addBook(Book book) {
        String sql="INSERT INTO book ('book_id','book_name','book_author)";
    }

    @Override
    public void deleteBook(int id) {

    }
}
