package com.getir.ReadingIsGood.controller;

import com.getir.ReadingIsGood.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void addNewBook(@RequestBody BookAddingRequest bookAddingRequest) {
        return bookService.addNewBook(bookAddingRequest);
    }

    @PutMapping(value = "/{id}")
    public void updateBookStock(@PathVariable("id") Integer id) {
        return bookService.updateBookStock(id);
    }
}

// ResponseEntity<?>
