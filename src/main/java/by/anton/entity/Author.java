package by.anton.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;
    @Column(name = "author_name")
    private String name;
    @Column(name = "author_soname")
    private String soname;

    public Author() {
    }
}
