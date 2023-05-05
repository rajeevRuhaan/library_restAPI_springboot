package com.rest_api.fs14backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "user1")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @Column(nullable = false,columnDefinition = "varchar(50)")
    private String firstname;

    @Column(nullable = false,columnDefinition = "varchar(50)")
    private String lastname;

    @Column(unique = true,nullable = false,columnDefinition = "varchar(50)")
    private String username;

    @Column
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
