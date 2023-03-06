package com.example.restcontrollerswebapi.services;

import com.example.restcontrollerswebapi.model.dtos.AuthorDTO;
import com.example.restcontrollerswebapi.model.dtos.BookDTO;
import com.example.restcontrollerswebapi.model.entities.Author;
import com.example.restcontrollerswebapi.model.entities.Book;
import com.example.restcontrollerswebapi.repositories.AuthorRepository;
import com.example.restcontrollerswebapi.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public long createBook(BookDTO newBook) {
        String authorName = newBook.getAuthor().getName();
        Optional<Author> authorOpt = this.authorRepository.findAuthorByName(authorName);

        Book bookToBeCreated = new Book().
                setTitle(newBook.getTitle()).
                setIsbn(newBook.getIsbn()).
                setAuthor(authorOpt.orElseGet(() -> createNewAuthor(authorName)));

       return bookRepository.save(bookToBeCreated).getId();

    }
    private Author createNewAuthor(String authorName) {
       return  authorRepository.save(new Author().setName(authorName));
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Optional<BookDTO>  findBookById(Long id) {
      return bookRepository.findById(id).map(this::map);
    }

    public List<BookDTO> getAllBooks() {
       return  bookRepository.findAll().
                stream().
                map(this::map).toList();
    }

    private BookDTO map(Book book) {

        AuthorDTO authorDTO = new AuthorDTO().
                setName(book.getAuthor().getName());

        return new BookDTO().setId(book.getId()).
                setAuthor(authorDTO).
                setIsbn(book.getIsbn()).
                setTitle(book.getTitle());

    }
}
