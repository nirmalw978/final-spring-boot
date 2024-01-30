package com.devStack.database.controller;


import com.devStack.database.dto.OrderDTO;
import com.devStack.database.entity.Orders;

import com.devStack.database.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Orders>> getAllOrders (){
        return ResponseEntity.status(200).body(orderService.getAllOrders());
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Orders> getProductById (@PathVariable Long id){

        Orders orders = orderService.getOrderById(id);
        if (orders !=null){
            return ResponseEntity.status(200).body(orderService.getOrderById(id));
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Orders> createOrder (@RequestBody OrderDTO orderDTO){
        try {
            return ResponseEntity.status(200).body(orderService.createOrder(orderDTO));
        }catch (Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Orders> updateOrder (@PathVariable Long id, @RequestBody Orders orders){
        Orders existingOrders = orderService.getOrderById(id);
        if (existingOrders != null){
            return ResponseEntity.status(200).body(orderService.updateOrder(id, orders));
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder (@PathVariable Long id){

        Orders deletingOrders = orderService.getOrderById(id);

        if (deletingOrders !=null){
            orderService.deleteOrder(id);
            return ResponseEntity.status(200).body("deleted successfully");
        }else {
            return ResponseEntity.status(404).body("order not found");
        }

    }
}
