package com.rest_api.fs14backend.entity;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table (name = "borrowers")
@NoArgsConstructor

public class Borrower {
    @Id
    @GeneratedValue()
    private UUID id;

    @Column
    private String name;

    private long bookId;

    public Borrower( String name,Long bookId ) {
        this.name = name;
        this.bookId = bookId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
}
