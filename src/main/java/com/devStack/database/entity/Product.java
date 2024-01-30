package com.devStack.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@JsonIgnoreProperties("catagory")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column
    private String product_name;

    @Column
    private String image;

    @Column
    private Double new_price;

    @Column
    private Double old_price;


    @ManyToOne
    @JoinColumn(name = "catagory_id")
    private Catagory catagory;
}



/*
package com.devStack.database.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    @Column
    private String product_name;

    @Column
    private String image;

    @Column
    private Double new_price;

    @Column
    private Double old_price;

    @ManyToOne
    @JoinColumn(name = "catagory_id")
    private Catagory catagory;
}
*/
