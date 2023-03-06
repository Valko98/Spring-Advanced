package com.example.restcontrollerswebapi.web;

import com.example.restcontrollerswebapi.model.dtos.BookDTO;
import com.example.restcontrollerswebapi.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {

        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long id) {
        Optional<BookDTO> theBook = bookService.findBookById(id);

        // same thing done in a simple way.
//        if(theBook.isPresent()) {
//            return ResponseEntity.ok(theBook.get());
//    }
//            return ResponseEntity.notFound().build();
//        }

        return theBook.map(ResponseEntity::ok).
                orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<BookDTO> deleteBookById(@PathVariable("id") Long id) {
        bookService.deleteById(id);

        return ResponseEntity
                .noContent()
                .build();
    }
    @PostMapping()
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO newBook,
                                              UriComponentsBuilder uriComponentsBuilder) {
       long newBookId = bookService.createBook(newBook);

      return ResponseEntity.created(uriComponentsBuilder.
               path("/api/books/{id}").build(newBookId)).build();

    }
}
