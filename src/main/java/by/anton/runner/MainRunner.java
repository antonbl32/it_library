package by.anton.runner;

import by.anton.security.SecurityUser;
import by.anton.service.BookService;
import by.anton.service.BookServiceImpl;

import java.beans.PropertyVetoException;
import java.util.Scanner;

public class MainRunner {
    private static BookService bookService = null;
    private static SecurityUser securityUser = null;

    static {
        try {
            bookService = new BookServiceImpl();
            securityUser = new SecurityUser();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        boolean auth = false;
        boolean isWork = true;
        do {
            if (!auth) {
                securityUser.authentication();
            }


        } while (isWork);

    }


    private static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        new MyMenu().init();
        int action = 0;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Введите положительное целое число больше 0 и меньше 4!");
                scanner.next();
            }
            action = scanner.nextInt();
        } while (action < 4 && action > 0);
        switch (action) {
            case 1:
                menuRead();
                break;
            case 2:
                menuAdd();
                break;
        }
    }

    private static void menuRead() {
        new MyMenu().readDB();

    }

    private static void menuAdd() {

    }
}
