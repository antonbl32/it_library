package by.anton.runner;

public class MyMenu {
    public void init(){
        System.out.println("-------------------------------------------");
        System.out.println("-----------MyLibrary database-------------");
        System.out.println("-----------Menu----------------------------");
        System.out.println("-----------Select 1 to read database------");
        System.out.println("-----------Select 2 to add to database----");
        System.out.println("-----------Select 3 to delete from database");
        System.out.println("-----------Select 4 to exit----------------");
        System.out.println("-------------------------------------------");
    }
    public void readDB(){
        System.out.println("-----------Menu read-----------------------");
        System.out.println("-----------Select 1 to read book by id-----");
        System.out.println("-----------Select 2 to read all books------");
        System.out.println("-----------Select 3 sort all books by name-");
        System.out.println("-----------Select 4 sort all books by Author");
        System.out.println("-----------Select 5 sort all books by Genre-");
        System.out.println("-----------Return to main menu 6------------");
    }
    public void addToDB(){
        System.out.println("-----------Menu add book-------------------");
        System.out.println("-----------Select 1 to create and add book-");
        System.out.println("-----------Return to main menu 2-----------");
    }
    public void deleteFromDB(){
        System.out.println("-----------Menu delete---------------------");
        System.out.println("-----------Select 1 to delete book by id---");
        System.out.println("-----------Return to main menu 2-----------");
    }
}
