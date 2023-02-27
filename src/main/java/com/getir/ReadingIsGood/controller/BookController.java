package com.getir.ReadingIsGood.controller;

import com.getir.ReadingIsGood.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/books")
public class BookController {

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping
    public void addNewBook(@RequestBody BookAddingRequest bookAddingRequest) {
        return bookService.addBook(bookAddingRequest);
    }

    @PutMapping(value = "/{id}")
    public void updateBookStock(@PathVariable("id") Integer id) {

        return bookService.updateBookStock(id);
    }
}

// ResponseEntity<?>
