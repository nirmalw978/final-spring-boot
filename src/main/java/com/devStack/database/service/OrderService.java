package com.devStack.database.service;

import com.devStack.database.dto.OrderDTO;
import com.devStack.database.entity.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    List<Orders> getAllOrders();
    Orders createOrder (OrderDTO orderDTO);
    Orders getOrderById(Long order_id);
    Orders updateOrder(Long order_id, Orders orders);
    void deleteOrder(Long order_id);
}
