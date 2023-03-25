package com.getir.ReadingIsGood.service;

import com.getir.ReadingIsGood.entity.Order;
import com.getir.ReadingIsGood.repository.CustomerRepository;
import com.getir.ReadingIsGood.response.MonthlyStatisticsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

import static java.util.Map.entry;

@Service
@RequiredArgsConstructor
public class MonthlyStatisticsService {
    private final CustomerRepository customerRepository;

    // todo: validation
    public List<MonthlyStatisticsResponse> getMonthlyStatisticByCustomerId(Long customerId) {

        List<MonthlyStatisticsResponse> responseList = new ArrayList<>();

        List<Order> orders = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"))
                .getOrders();

        // to eliminate unnecessary database queries, we should avoid using getOrdersByDate() method

        // to eliminate unnecessary string manipulation, we should use a map

        // Map.of() only works up to 10 entries, so we need to use Map.ofEntries()

        Map<Integer, String> monthsMap = Map.ofEntries(
                entry(1, "January"),
                entry(2, "February"),
                entry(3, "March"),
                entry(4, "April"),
                entry(5, "May"),
                entry(6, "June"),
                entry(7, "July"),
                entry(8, "August"),
                entry(9, "September"),
                entry(10, "October"),
                entry(11, "November"),
                entry(12, "December")
        );

        int year = LocalDate.now().getYear();
        for (int month = 1; month <= 12; month++) {
            YearMonth yearMonth = YearMonth.of(year, month);
            LocalDate startDate = yearMonth.atDay(1);
            LocalDate endDate = yearMonth.atEndOfMonth();

            List<Order> ordersBetweenDays = orders.stream()
                    .filter(order -> order.getOrderDate().isAfter(startDate) && order.getOrderDate().isBefore(endDate))
                    .sorted(Comparator.comparing(Order::getOrderDate, Comparator.reverseOrder()))
                    .toList();

            MonthlyStatisticsResponse monthlyStatisticsResponse = MonthlyStatisticsResponse.builder()
                    .month(
                            monthsMap.get(month)
                    )
                    .totalOrderCount(
                            ordersBetweenDays.size()
                    )
                    .totalBookCount(
                            ordersBetweenDays.stream()
                            .mapToInt(order -> order.getBooks().size())
                            .sum()
                    )
                    .totalPurchasedAmount(
                            ordersBetweenDays.stream().map(Order::getTotalPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add)
                    )
                    .build();
            if (monthlyStatisticsResponse.getTotalOrderCount() != 0) {
                responseList.add(monthlyStatisticsResponse);
            }
        }
        return responseList;
    }
}