package by.anton;

import by.anton.dao.BookDAO;
import by.anton.dao.BookDAOImpl;

public class Runner {
    public static void main(String[] args) {
        try {
            BookDAO bookDAO=new BookDAOImpl();
            System.out.println(bookDAO.getAllBooks());
            System.out.println(bookDAO.getBookById(1));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
