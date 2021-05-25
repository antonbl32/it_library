package by.anton.runner;

import by.anton.service.BookService;
import by.anton.service.BookServiceImpl;

import java.beans.PropertyVetoException;
import java.util.Scanner;

public class MainRunner {
    private static BookService bookService = null;

    static {
        try {
            bookService = new BookServiceImpl();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new MyMenu().init();
        int action=0;
        // for main menu
        do{
            scanner.next();
            if(scanner.hasNextInt()){
                action=scanner.nextInt();
            }else{
                System.out.println("must be from 1 to 3");
            }
        }while (action<=0||action>4);
        switch (action){
            case 1:
                menuRead();
                break;
            case 2:
                menuAdd();
                break;
        }
    }
    private static void menuRead(){
        new MyMenu().readDB();

    }
    private static void menuAdd(){

    }
}
