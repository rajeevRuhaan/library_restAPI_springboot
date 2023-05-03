package com.rest_api.fs14backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "user")
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(unique = true,nullable = false,columnDefinition = "varchar(50)")
    private String username;

    @Column(nullable = false,columnDefinition = "varchar(50)")
    private String email;

    @Column
    private UUID password;

}
