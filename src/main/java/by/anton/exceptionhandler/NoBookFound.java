package by.anton.exceptionhandler;

public class NoBookFound extends RuntimeException{
    public NoBookFound(String message) {
        super(message);
    }
}
