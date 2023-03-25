package com.getir.ReadingIsGood.controller;

import com.getir.ReadingIsGood.entity.Order;
import com.getir.ReadingIsGood.request.CustomerRequest;
import com.getir.ReadingIsGood.response.CustomerResponse;
import com.getir.ReadingIsGood.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{customerId}/orders")
    public Page<Order> getAllOrdersByCustomerId(
            @PathVariable("customerId") Long customerId,
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        return customerService.getAllOrdersByCustomerId(customerId, page, size);
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> registerCustomer(@RequestBody CustomerRequest request) {
        return ResponseEntity.ok(customerService.registerCustomer(request));
    }
}