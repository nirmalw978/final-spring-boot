package com.devStack.database.service;
import com.devStack.database.dto.OrderDTO;
import com.devStack.database.entity.Customer;
import com.devStack.database.entity.Orders;
import com.devStack.database.entity.Product;
import com.devStack.database.repository.CustomerRepository;
import com.devStack.database.repository.OrderRepository;
import com.devStack.database.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Orders createOrder(OrderDTO orderDTO) {

        Customer customer = customerRepository.findById(orderDTO.getCustomerId()).orElse(null);
        if (customer == null) {
            throw new RuntimeException("Customer not found with id: " + orderDTO.getCustomerId());
        }
        else{
            Set<Product> products = productRepository.findAllById(orderDTO.getProductIds()).stream().collect(Collectors.toSet());

            // Create a new order
            Orders order = new Orders();
            order.setTotalPrice(orderDTO.getTotalPrice());
            order.setTotalItems(orderDTO.getTotalItems());
            order.setCustomer(customer);
            order.setProducts(products);

            // Save the order to the database
            return orderRepository.save(order);
        }




    }

    @Override
    public Orders getOrderById(Long order_id) {
        return orderRepository.findById(order_id).orElse(null);
    }

    @Override
    public Orders updateOrder(Long order_id, Orders orders) {
        Orders existingOrders = orderRepository.findById(order_id).orElse(null);
        if (existingOrders != null) {

            existingOrders.setTotalPrice(orders.getTotalPrice());
            existingOrders.setTotalItems(orders.getTotalItems());

            return orderRepository.save(existingOrders);
        } else {
            return null;
        }
    }

    @Override
    public void deleteOrder(Long order_id) {
            orderRepository.deleteById(order_id);
        }

    }

