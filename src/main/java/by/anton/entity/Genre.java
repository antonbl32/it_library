package by.anton.entity;

import lombok.Data;
@Data
public class Genre {
    private int id;
    private String type;
    private String description;

    public Genre() {
    }
}
