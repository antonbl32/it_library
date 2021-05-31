package by.anton.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    @NonNull
    private String name;
    @NonNull
    private Author author;
    @NonNull
    private Genre genre;
    @NonNull
    private User user;
}
