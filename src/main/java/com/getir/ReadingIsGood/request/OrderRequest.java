package com.getir.ReadingIsGood.request;

import com.getir.ReadingIsGood.entity.Book;
import com.getir.ReadingIsGood.entity.Customer;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// todo: fix members

@Data
@Builder
public class OrderRequest {
    private Customer customer;
    private List<Book> books;
    private BigDecimal totalPrice;
    private LocalDate orderDate;
}
