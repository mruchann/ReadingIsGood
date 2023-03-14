package com.getir.ReadingIsGood.response;

import com.getir.ReadingIsGood.entity.Order;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerResponse {
    private List<Order> orders;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
