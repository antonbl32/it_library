package by.anton.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
@Data
@AllArgsConstructor
@Entity
@Table(name ="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private  int id;
    @Column(name = "book_name")
    private String name;
    @ManyToOne(targetEntity = Author.class,fetch = FetchType.EAGER)
    private Author author;
    @ManyToOne(targetEntity = Genre.class,fetch = FetchType.EAGER)
    private Genre genre;
    @ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    private User user;

    public Book() {
    }
}
