package by.anton.runner;

import by.anton.security.SecurityUser;
import by.anton.service.BookService;
import by.anton.service.BookServiceImpl;

import java.beans.PropertyVetoException;
import java.util.Scanner;

public class MainRunner {
    private static BookService bookService = null;
    private static SecurityUser securityUser = null;
    private static int key = 0;
    private static boolean auth = false;
    private static boolean isWork = true;
    static {
        try {
            bookService = new BookServiceImpl();
            securityUser = new SecurityUser();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        securityUser.getRole();
        do {
            mainMenu();
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
        } while (action > 4 && action < 0);
        switch (action) {
            case 1:
                menuRead();
                break;
            case 2:
                menuAdd();
                break;
            case 3:
                menuDelete();
                break;
            case 4:
                isWork=false;
                return;

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
        } while (action > 7 && action < 0);
        switch (action) {
            case 1:
                System.out.println("Введите id книги");
                int id = scanner.nextInt();
                System.out.println(bookService.getBookById(id));
                break;
            case 2:
                System.out.println(bookService.getAllBooks());
                break;
            case 3:
                System.out.println(bookService.sortBooksByName(bookService.getAllBooks()));
                break;
            case 4:
                System.out.println(bookService.sortBooksByAuthor(bookService.getAllBooks()));
                break;
            case 5:
                System.out.println(bookService.sortBooksByGenre(bookService.getAllBooks()));
                break;
            case 6:
                mainMenu();
                break;
        }
    }

    private static void menuAdd() {
        new MyMenu().addToDB();
        Scanner scanner = new Scanner(System.in);
        int action;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Введите положительное целое число больше 0 и меньше 3!");
                scanner.next();
            }
            action = scanner.nextInt();
        } while (action > 3 && action < 0);
        switch (action) {
            case 1:
                bookService.createBook();
                break;
            case 2:
                mainMenu();
                break;
        }
    }

    private static void menuDelete() {
        new MyMenu().readDB();
        Scanner scanner = new Scanner(System.in);
        int action;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Введите положительное целое число больше 0 и меньше 2!");
                scanner.next();
            }
            action = scanner.nextInt();
        } while (action > 3 && action < 0);
        switch (action) {
            case 1:
                System.out.println("Введите id книги для удаления");
                int id = scanner.nextInt();
                bookService.deleteBook(id);
                break;
            case 2:
                mainMenu();
                break;
        }
    }
}
