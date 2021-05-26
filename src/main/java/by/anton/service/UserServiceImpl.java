package by.anton.service;

import by.anton.dao.UserDAO;
import by.anton.dao.UserDAOImpl;
import by.anton.entity.User;

import java.beans.PropertyVetoException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO=new UserDAOImpl();

    public UserServiceImpl() throws PropertyVetoException {
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
