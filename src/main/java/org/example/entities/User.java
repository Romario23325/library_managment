package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.example.static_data.Role;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
