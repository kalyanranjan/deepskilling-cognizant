package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public String fetchBooks() {
        return "BookRepository: Fetching Books";
    }
}
