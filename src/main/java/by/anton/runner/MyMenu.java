package by.anton.runner;

public class MyMenu {
    public void init(){
        System.out.println("-------------------------------------------");
        System.out.println("-----------MyLibrary data base-------------");
        System.out.println("-----------Before each task enter your key-");
        System.out.println("-----------Menu----------------------------");
        System.out.println("-----------Select 1 to read data base------");
        System.out.println("-----------Select 2 to add to data base----");
        System.out.println("-----------Select 3 to delete from data base");
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
        System.out.println("-----------Select 2 to add author----------");
        System.out.println("-----------Return to main menu 3-----------");
    }
    public void deleteFromDB(){
        System.out.println("-----------Menu delete---------------------");
        System.out.println("-----------Select 1 to delete book by id---");
        System.out.println("-----------Return to main menu 2-----------");
    }
}
