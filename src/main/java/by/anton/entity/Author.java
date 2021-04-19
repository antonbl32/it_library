package by.anton.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {

    private int id;
    private String name;
    private String soname;

    public Author() {
    }
}
