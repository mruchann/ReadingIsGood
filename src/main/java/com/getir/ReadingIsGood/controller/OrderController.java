package com.getir.ReadingIsGood.controller;

import com.getir.ReadingIsGood.entity.Order;
import com.getir.ReadingIsGood.request.OrderRequest;
import com.getir.ReadingIsGood.response.OrderResponse;
import com.getir.ReadingIsGood.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<OrderResponse> addNewOrder(@RequestBody OrderRequest request) {
        return ResponseEntity.ok(orderService.addNewOrder(request));
    }

    @GetMapping("/{orderId}")
    public Order getByOrderId(@PathVariable Long orderId) {
        return orderService.getByOrderId(orderId);
    }

    // example date: 2000-10-31
    @GetMapping("/date")
    public List<Order> getOrdersByDate(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {

        return orderService.getOrdersByDate(startDate, endDate);
    }
}