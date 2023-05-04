package com.rest_api.fs14backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @Column(nullable = false,columnDefinition = "varchar(50)")
    private String title;
    @Column(nullable = false,columnDefinition = "varchar(50)")
    private String isbn;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private Date publishedDate;
    @Column(nullable = false)
    private String publisher;
    @Column(nullable = false)
    private String cover;
}
