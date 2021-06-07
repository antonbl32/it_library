package by.anton.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Role {
    private int id;
    private int isAdmin;
    private int isUser;
}
