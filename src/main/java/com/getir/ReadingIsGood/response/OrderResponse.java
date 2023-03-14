package com.getir.ReadingIsGood.response;

import com.getir.ReadingIsGood.entity.Book;
import com.getir.ReadingIsGood.entity.Customer;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class OrderResponse {
    private Customer customer;
    private List<Book> books;
    private BigDecimal totalPrice;
    private LocalDate orderDate;
}
