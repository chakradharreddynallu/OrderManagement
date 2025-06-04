package com.orderManagement.demo.service;

import com.orderManagement.demo.model.Customer;
import com.orderManagement.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepo;

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepo.findById(id).orElseThrow();
    }
}
