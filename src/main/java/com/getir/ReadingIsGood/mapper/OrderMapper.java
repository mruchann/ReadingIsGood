package com.getir.ReadingIsGood.mapper;

import com.getir.ReadingIsGood.entity.Order;
import com.getir.ReadingIsGood.response.OrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponse toOrderResponse(Order order);
}

