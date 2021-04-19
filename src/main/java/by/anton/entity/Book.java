package by.anton.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Book {
    private  int id;
    private String name;
    private Author author;
    private Genre genre;
    private User user;

    public Book() {
    }
}
