package com.getir.ReadingIsGood.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BookRequest {
    private String name;
    private String author;
    private BigDecimal price;
    private Integer stock;

}
