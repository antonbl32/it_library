package by.anton.entity;

import lombok.Data;
@Data
public class Role {
    private int id;
    private int isAdmin;
    private int isUser;

    public Role() {
    }
}
