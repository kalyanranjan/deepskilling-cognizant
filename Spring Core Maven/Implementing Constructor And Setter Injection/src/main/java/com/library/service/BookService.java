package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private final BookRepository bookRepository;
    private String libraryName;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public void serveBooks() {
        System.out.println(bookRepository.fetchBooks());
        System.out.println("BookService: Serving Books At " + libraryName);
    }
}
