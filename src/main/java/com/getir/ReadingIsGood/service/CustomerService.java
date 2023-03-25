package com.getir.ReadingIsGood.service;

import com.getir.ReadingIsGood.entity.Customer;
import com.getir.ReadingIsGood.entity.Order;
import com.getir.ReadingIsGood.mapper.CustomerMapper;
import com.getir.ReadingIsGood.repository.CustomerRepository;
import com.getir.ReadingIsGood.repository.OrderRepository;
import com.getir.ReadingIsGood.request.CustomerRequest;
import com.getir.ReadingIsGood.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;


    public Page<Order> getAllOrdersByCustomerId(Long customerId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderRepository.getAllOrdersByCustomerId(customerId, pageable);
    }

    // todo: validation
    public CustomerResponse registerCustomer(@NotNull CustomerRequest request) {
        if (customerRepository.existsCustomerByEmail(request.getEmail())) {
            throw new RuntimeException("Customer already exists");
        }
        Customer customer = Customer.builder()
            .orders(request.getOrders())
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .password(request.getPassword())
            .build();
        return customerMapper.toCustomerResponse(customerRepository.save(customer));
    }

}
