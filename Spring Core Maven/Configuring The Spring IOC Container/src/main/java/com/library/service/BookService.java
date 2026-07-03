package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void serveBooks() {
        System.out.println(bookRepository.fetchBooks());
        System.out.println("BookService: Serving Books To Library Members");
    }
}
