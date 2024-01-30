package com.devStack.database.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class customerDTO {
    private String customer_name;
    private String email;
    private String password;
    private Long orderId;
}
