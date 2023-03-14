package com.getir.ReadingIsGood.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {

//    @Getter(AccessLevel.NONE)
//    @Setter(AccessLevel.NONE)
    @Id
    private Long id;
    private String name;
    private String author;
    private BigDecimal price;
    private Integer stock;
}
