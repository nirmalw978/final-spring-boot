package com.devStack.database.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private Double totalPrice;
    private Long totalItems;
    private Long customerId;
    private List<Long> productIds;


}
