package com.getir.ReadingIsGood.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BookResponse {
    private String name;
    private String author;
    private BigDecimal price;
    private Integer stock;

}
