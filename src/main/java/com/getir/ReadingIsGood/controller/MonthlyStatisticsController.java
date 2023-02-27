package com.getir.ReadingIsGood.controller;

import com.getir.ReadingIsGood.service.MonthlyStatisticsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/statistics")
public class MonthlyStatisticsController {

    private final MonthlyStatisticsService monthlyStatisticsService;

    public MonthlyStatisticsController(MonthlyStatisticsService monthlyStatisticsService) {
        this.monthlyStatisticsService = monthlyStatisticsService;
    }
}
