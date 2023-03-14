package com.getir.ReadingIsGood.mapper;

import com.getir.ReadingIsGood.entity.Order;
import com.getir.ReadingIsGood.response.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;

@Mapper
public interface OrderMapper {
    @Mappings({
            @Mapping(source = "customer", target = "orderResponse.customer"),
            @Mapping(source = "books", target = "orderResponse.books"),
            @Mapping(source = "totalPrice", target = "orderResponse.totalPrice"),
            @Mapping(source = "orderDate", target = "orderResponse.orderDate")
    })
    OrderResponse toOrderResponse(Order order);
}

