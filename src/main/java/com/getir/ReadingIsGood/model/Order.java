package com.getir.ReadingIsGood.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Order {
    @Id
    private Long orderId;
    private Long customerId;
    private Long bookId;
    private Double totalPrice;
    private LocalDateTime orderTime;
}
