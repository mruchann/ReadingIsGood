package com.getir.ReadingIsGood.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Book {
    @Id
    private Long id;
    private String name;
    private String author;
    private String price;
    private Integer stock;
}
