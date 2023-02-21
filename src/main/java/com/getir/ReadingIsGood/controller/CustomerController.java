package com.getir.ReadingIsGood.controller;

import com.getir.ReadingIsGood.model.Order;
import com.getir.ReadingIsGood.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/{id}")
    public List<Order> listCustomerOrdersById(@PathVariable("id") Integer id) {
        return customerService.listCustomerOrdersById(id);
    }

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        return customerService.registerCustomer(customerRegistrationRequest);
    }
}

// ResponseEntity<?>

// DAO - DTO