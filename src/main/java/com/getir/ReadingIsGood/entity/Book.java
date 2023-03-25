package com.getir.ReadingIsGood.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "books")
public class Book {

    @Id
    @SequenceGenerator(name = "book_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    @Column(updatable = false)
    private Long id;

    private String name;

    private String author;

    private BigDecimal price;

    private Integer stock;
}
