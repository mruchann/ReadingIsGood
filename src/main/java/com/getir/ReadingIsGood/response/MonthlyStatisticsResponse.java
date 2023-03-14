package com.getir.ReadingIsGood.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MonthlyStatisticsResponse {
    private String month;
    private Integer totalOrderCount;
    private Integer totalBookCount;
    private BigDecimal totalPurchasedAmount;
}
