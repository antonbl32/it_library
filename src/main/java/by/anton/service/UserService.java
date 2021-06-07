package by.anton.service;

import by.anton.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(int id);

}
