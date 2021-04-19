package by.anton.entity;

import lombok.Data;

@Data
public class Author {

    private int id;
    private String name;
    private String soname;

    public Author() {
    }
}
