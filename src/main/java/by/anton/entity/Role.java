package by.anton.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Role {
    private int id;
    private String group;
    private int isAdmin;
    private int isUser;
}
