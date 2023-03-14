package com.getir.ReadingIsGood.request;

import com.getir.ReadingIsGood.entity.Order;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerRequest {
    private List<Order> orders;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
