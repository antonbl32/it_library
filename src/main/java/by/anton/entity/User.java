package by.anton.entity;

import lombok.Data;
@Data
public class User {
    private int id;
    private String name;
    private String password;
    private Role role;

    public User() {
    }
}
