package by.anton.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;
    @Column(name = "role_admin")
    private int isAdmin;
    @Column(name = "role_user")
    private int isUser;

    public Role() {
    }
}
