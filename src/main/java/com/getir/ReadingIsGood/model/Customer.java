package com.getir.ReadingIsGood.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Customer {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
