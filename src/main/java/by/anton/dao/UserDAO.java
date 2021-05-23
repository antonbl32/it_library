package by.anton.dao;

import by.anton.entity.Book;
import by.anton.entity.User;

import java.util.List;

public interface UserDAO {
    Book getUserById(int id);

    List<Book> getAllUsers();

    void addUser(User user);

    void deleteUser(int id);
}
