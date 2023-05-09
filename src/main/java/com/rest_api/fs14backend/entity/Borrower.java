package com.rest_api.fs14backend.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@Entity
@Table (name = "borrower")
@NoArgsConstructor
@Data
public class Borrower {
    @Id
    @GeneratedValue()
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;
    @OneToOne(optional = false)
    private BookCopy bookCopy;


    public Borrower(User user, BookCopy bookCopy) {
        this.user = user;
        this.bookCopy = bookCopy;
    }

    public Borrower(Optional<User> user, BookCopy bookCopy) {
    }
}
