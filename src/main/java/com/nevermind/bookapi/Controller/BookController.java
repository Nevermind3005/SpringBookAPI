package com.nevermind.bookapi.Controller;

import com.nevermind.bookapi.Models.Book;
import com.nevermind.bookapi.Services.IBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.get();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        var book = bookService.getById(id);
        if (book == null) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        var newBook = bookService.add(book);
        return new ResponseEntity<Book>(newBook, HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book, @PathVariable long id) {
        book.setId(id);
        var newBook = bookService.add(book);
        return new ResponseEntity<Book>(newBook, HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable long id) {
        bookService.deleteById(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.NO_CONTENT);
    }

}
