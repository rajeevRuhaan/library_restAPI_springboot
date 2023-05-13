package com.rest_api.fs14backend.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;
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
    @JoinColumn(name="userId", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User user;

    @OneToOne(optional = false)
    private BookCopy bookCopy;

    private Date borrowDate;

    private Date returnDate;

   public UUID userId() {
        return user.getId();
   }
    public Borrower(User user, BookCopy bookCopy, Date borrowDate, Date returnDate) {
        this.user = user;
        this.bookCopy = bookCopy;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

}
