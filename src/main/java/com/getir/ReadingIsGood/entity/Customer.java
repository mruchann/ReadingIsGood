package com.getir.ReadingIsGood.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "customers")
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    @Column(updatable = false)
    private Long id;

    @Column
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
}
