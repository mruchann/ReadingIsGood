package com.getir.ReadingIsGood.controller;

import com.getir.ReadingIsGood.request.BookRequest;
import com.getir.ReadingIsGood.response.BookResponse;
import com.getir.ReadingIsGood.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;


@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<BookResponse> addNewBook(@RequestBody BookRequest request) {
        return ResponseEntity.ok(bookService.addNewBook(request));
    }

    @PutMapping("stock-update/{bookId}")
    public ResponseEntity<BookResponse> updateBookStock(@PathVariable Long bookId, @RequestParam Integer stock) {
        return ResponseEntity.ok(bookService.updateBookStock(bookId, stock));
    }

    @PutMapping("price-update/{bookId}")
    public ResponseEntity<BookResponse> updatePrice(@PathVariable Long bookId, @RequestParam BigDecimal price) {
        return ResponseEntity.ok(bookService.updatePrice(bookId, price));
    }
}