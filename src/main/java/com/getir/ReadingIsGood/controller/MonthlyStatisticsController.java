package com.getir.ReadingIsGood.controller;

import com.getir.ReadingIsGood.response.MonthlyStatisticsResponse;
import com.getir.ReadingIsGood.service.MonthlyStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/statistics")
@RequiredArgsConstructor
public class MonthlyStatisticsController {
    private final MonthlyStatisticsService monthlyStatisticsService;

    @GetMapping("customer/{customerId}")
    public List<MonthlyStatisticsResponse> getMonthlyStatisticByCustomerId(@PathVariable("customerId") Long customerId) {
        return monthlyStatisticsService.getMonthlyStatisticByCustomerId(customerId);
    }
}
