package com.getir.ReadingIsGood.repository;

import com.getir.ReadingIsGood.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsCustomerByEmail(String email);
}
