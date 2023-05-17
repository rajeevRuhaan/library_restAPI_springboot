package com.rest_api.fs14backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
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
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_Id", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Author author;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_Id", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Category category;
    @Column(nullable = false)
    private Date publishedDate;
    @Column(nullable = false)
    private String publisher;
    @Column(nullable = false)
    private String coverImageUrl;
    @Column(nullable = true)
    @Lob
    private String description;


    public Book(String title, String isbn, Author author, Category category, Date publishedDate, String publisher, String coverImageUrl, String description) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.category = category;
        this.publishedDate = publishedDate;
        this.publisher = publisher;
        this.coverImageUrl = coverImageUrl;
        this.description = description;
    }
}
