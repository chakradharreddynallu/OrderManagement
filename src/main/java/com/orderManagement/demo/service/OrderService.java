package com.orderManagement.demo.service;

import com.orderManagement.demo.model.Customer;
import com.orderManagement.demo.model.Order;
import com.orderManagement.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.orderManagement.demo.repository.CustomerRepository;

import java.util.List;
@Service

public class OrderService {
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private CustomerRepository customerRepo;

    public Order placeOrder(Long customerId, Order order) {
        Customer customer = customerRepo.findById(customerId).orElseThrow();
        order.setCustomer(customer);
        return orderRepo.save(order);
    }

    public List<Order> getOrdersByCustomer(Long customerId) {
        return orderRepo.findByCustomerId(customerId);
    }
}
