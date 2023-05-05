package com.rest_api.fs14backend.dao;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
public class BookDao {
        private UUID categoryId;
        private UUID authorID;
        private String title;
        private String isbn;
        private Date publishedDate;
        private String publisher;
        private String cover;
}
