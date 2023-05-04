package com.rest_api.fs14backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCopy {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
   // @ManyToOne(optional = false)
    private String bookId;

}
