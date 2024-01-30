package com.devStack.database.controller;

import com.devStack.database.entity.Customer;
import com.devStack.database.entity.Product;
import com.devStack.database.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Customer>> getCustomers (){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomers());
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer (@RequestBody Customer customer){
        return ResponseEntity.status(200).body(customerService.createCustomer(customer));
    }


    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Customer> getCustomerById (@PathVariable Long id){

        Customer customer= customerService.getCustomerById(id);

        if (customer!=null){
            return ResponseEntity.status(200).body(customerService.getCustomerById(id));
        }else {
            return ResponseEntity.status(404).body(null);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer (@PathVariable Long id,@RequestBody Customer customer){

        try {
            return ResponseEntity.status(200).body(customerService.updateCustomer(id, customer));
        }catch (Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
    }
}
