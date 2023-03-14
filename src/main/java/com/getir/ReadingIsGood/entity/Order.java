package com.getir.ReadingIsGood.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {
    @Id
//    @Getter(AccessLevel.NONE)
//    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Book> books;

    private BigDecimal totalPrice;

    private LocalDate orderDate;
}
