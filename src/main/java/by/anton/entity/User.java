package by.anton.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_password")
    private String password;
    @ManyToOne(targetEntity = Role.class, fetch = FetchType.EAGER)
    private Role role;

    public User() {
    }
}
