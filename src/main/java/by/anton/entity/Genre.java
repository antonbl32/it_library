package by.anton.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Genre {
    private int id;
    private String type;
    private String description;

    public Genre() {
    }
}
