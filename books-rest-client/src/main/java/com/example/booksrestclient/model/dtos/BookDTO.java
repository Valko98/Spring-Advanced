package com.example.booksrestclient.model.dtos;



public class BookDTO {

    private long id;

    private String title;

    private String isbn;

    private AuthorDTO author;

    public BookDTO setId(long id) {
        this.id = id;
        return this;
    }

    public BookDTO setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookDTO setAuthor(AuthorDTO author) {
        this.author = author;
        return this;
    }
}
