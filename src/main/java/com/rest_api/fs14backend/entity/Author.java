package com.rest_api.fs14backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="author")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String firstName;
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String lastName;
    @Column(nullable = true, columnDefinition = "varchar(50)")
    private String email;
    @Column(nullable = true, columnDefinition = "varchar(50)")
    private String phone;


}
