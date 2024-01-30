package com.devStack.database.service;

import com.devStack.database.entity.Customer;
import com.devStack.database.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long customer_id) {

        return customerRepository.findById(customer_id).orElse(null);
    }

    @Override
    public Customer updateCustomer(Long customer_id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer_id).orElse(null);
        if (existingCustomer != null){

            existingCustomer.setCustomer_name(customer.getCustomer_name());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPassword(customer.getPassword());

            return customerRepository.save(existingCustomer);

        }else {
            return null;
        }
    }

    @Override
    public void deleteCustomer(Long customer_id) {
       customerRepository.deleteById(customer_id);
    }
}
