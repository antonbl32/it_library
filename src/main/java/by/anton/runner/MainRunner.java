package by.anton.runner;

import by.anton.security.SecurityUser;
import by.anton.service.BookService;
import by.anton.service.BookServiceImpl;

import java.beans.PropertyVetoException;
import java.util.Scanner;

public class MainRunner {
    private static BookService bookService = null;
    private static SecurityUser securityUser = null;
    private static int key=0;
    private static boolean auth = false;

    static {
        try {
            bookService = new BookServiceImpl();
            securityUser = new SecurityUser();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        boolean isWork = true;
        Scanner scanner=new Scanner(System.in);
        securityUser.getRole();
        do {
            mainMenu();
            if(scanner.next().equalsIgnoreCase("exit")){
                isWork=false;
            }
        } while (isWork);
    }

    private static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        new MyMenu().init();
        int action;
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
        Scanner scanner = new Scanner(System.in);
        int action;
        do {

            while (!scanner.hasNextInt()) {
                System.out.println("Введите положительное целое число больше 0 и меньше 4!");
                scanner.next();
            }
            action = scanner.nextInt();
        } while (action < 4 && action > 0);
        switch (action) {
            case 1:
                bookService.getAllBooks()
                break;
            case 2:
                bookService.addBook();
                break;
        }
    }

    private static void menuAdd() {

    }
}
