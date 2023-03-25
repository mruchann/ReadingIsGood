package com.getir.ReadingIsGood.mapper;

import com.getir.ReadingIsGood.entity.Customer;
import com.getir.ReadingIsGood.response.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerResponse toCustomerResponse(Customer customer);
}
