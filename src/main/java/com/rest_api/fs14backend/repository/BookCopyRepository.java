package com.rest_api.fs14backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

import com.rest_api.fs14backend.entity.BookCopy;
@Repository
public interface BookCopyRepository extends JpaRepository<BookCopy, UUID> {
}
