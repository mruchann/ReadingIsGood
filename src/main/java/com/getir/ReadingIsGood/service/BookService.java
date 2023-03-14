package com.getir.ReadingIsGood.service;

import com.getir.ReadingIsGood.entity.Book;
import com.getir.ReadingIsGood.mapper.BookMapper;
import com.getir.ReadingIsGood.repository.BookRepository;
import com.getir.ReadingIsGood.request.BookRequest;
import com.getir.ReadingIsGood.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    // todo: validation
    public BookResponse addNewBook(@NotNull BookRequest request) {
        Book book = Book.builder()
            .name(request.getName())
            .author(request.getAuthor())
            .price(request.getPrice())
            .stock(request.getStock())
            .build();
        return bookMapper.toBookResponse(bookRepository.save(book));
    }

    // todo: validation
    public BookResponse updateBookStock(Long bookId, Integer stock) {
        Book book = bookRepository
                .findById(bookId)
                .orElseThrow( () -> new RuntimeException("Book not found"));

        book.setStock(stock);
        return bookMapper.toBookResponse(bookRepository.save(book));
    }

    // todo: validation
    public BookResponse updatePrice(Long bookId, BigDecimal price) {
        Book book = bookRepository
                .findById(bookId)
                .orElseThrow( () -> new RuntimeException("Book not found"));

        book.setPrice(price);
        return bookMapper.toBookResponse(bookRepository.save(book));
    }
}
