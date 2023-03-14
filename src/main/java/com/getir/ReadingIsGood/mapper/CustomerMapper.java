package com.getir.ReadingIsGood.mapper;

import com.getir.ReadingIsGood.entity.Customer;
import com.getir.ReadingIsGood.response.CustomerResponse;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

public interface CustomerMapper {
    @Mappings({
            @Mapping(source = "orders", target = "customer.orders"),
            @Mapping(source = "firstName", target = "customer.firstName"),
            @Mapping(source = "lastName", target = "customer.lastName"),
            @Mapping(source = "email", target = "customer.email"),
            @Mapping(source = "password", target = "customer.password")
    })
    CustomerResponse toCustomerResponse(Customer customer);
}
