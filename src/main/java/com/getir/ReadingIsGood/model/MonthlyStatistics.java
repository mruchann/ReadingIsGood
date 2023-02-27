package com.getir.ReadingIsGood.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class MonthlyStatistics {
    private String month;
    private Integer totalOrderCount;
    private Integer totalBookCount;
    private Double totalPurchasedAmount;
}
