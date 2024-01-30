package com.devStack.database.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String product_name;
    private String image;
    private Double new_price;
    private Double old_price;
    private Long catagoryId;

}
