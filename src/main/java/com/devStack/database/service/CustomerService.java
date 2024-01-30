package com.devStack.database.service;

import com.devStack.database.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer createCustomer (Customer customer);
    Customer getCustomerById(Long customer_id);

    Customer updateCustomer(Long customer_id,Customer customer);

    void deleteCustomer(Long customer_id);
}
