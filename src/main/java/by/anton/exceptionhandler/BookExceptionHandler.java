package by.anton.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BookIncorrectData> exceptionEmployeeHandler(NoBookFound e) {
        BookIncorrectData data = new BookIncorrectData();
        data.setInfo(e.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<BookIncorrectData> exceptionEmployeeHandler(Exception e){
        BookIncorrectData data=new BookIncorrectData();
        data.setInfo(e.getMessage());
        return  new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}