package com.getir.ReadingIsGood.repository;

import com.getir.ReadingIsGood.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> getAllOrdersByCustomerId(Long customerId, Pageable pageable);
}
