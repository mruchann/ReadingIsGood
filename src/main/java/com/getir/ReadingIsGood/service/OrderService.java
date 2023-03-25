package com.getir.ReadingIsGood.service;

import com.getir.ReadingIsGood.entity.Book;
import com.getir.ReadingIsGood.entity.Order;
import com.getir.ReadingIsGood.mapper.OrderMapper;
import com.getir.ReadingIsGood.repository.BookRepository;
import com.getir.ReadingIsGood.repository.OrderRepository;
import com.getir.ReadingIsGood.request.OrderRequest;
import com.getir.ReadingIsGood.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    // todo: validation
    public OrderResponse addNewOrder(@NotNull OrderRequest request) {
        Order order = Order.builder()
            .customer(request.getCustomer())
            .books(request.getBooks())
            .totalPrice(request.getTotalPrice())
            .orderDate(LocalDate.now())
            .build();

        for (Book book : order.getBooks()) {
            Integer newStock = book.getStock() - 1;
            book.setStock(newStock);
            bookRepository.save(book);
        }

        return orderMapper.toOrderResponse(orderRepository.save(order));
    }
    public Order getByOrderId(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow( () -> new RuntimeException("Order not found"));
    }

    public List<Order> getOrdersByDate(LocalDate startDate, LocalDate endDate) {
        return orderRepository.findAll().stream()
                .filter(order -> order.getOrderDate().isAfter(startDate) && order.getOrderDate().isBefore(endDate))
                .sorted(Comparator.comparing(Order::getOrderDate, Comparator.reverseOrder()))
                .toList();
    }
}
