package com.rest_api.fs14backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
public class BookCopy {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id")
    private Book book;
    private Boolean isAvailable= true;

    public  BookCopy(Book book){
        this.book = book;
    }

}
