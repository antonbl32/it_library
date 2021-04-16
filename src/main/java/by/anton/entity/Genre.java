package by.anton.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int id;
    @Column(name = "genre_type")
    private String type;
    @Column(name = "genre_desc")
    private String description;

    public Genre() {
    }
}
