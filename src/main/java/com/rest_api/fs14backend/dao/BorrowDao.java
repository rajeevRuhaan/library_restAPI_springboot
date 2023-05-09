package com.rest_api.fs14backend.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowDao {
    private UUID id;
    private UUID userId;
    private UUID bookCopyId;

}
