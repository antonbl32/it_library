package by.anton.dao;

import by.anton.entity.Book;
import by.anton.entity.User;

import java.util.List;

public interface UserDAO {
    User getUserById(int id);

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(int id);
}
