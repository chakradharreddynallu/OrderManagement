package com.orderManagement.demo.controller;

import com.orderManagement.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/{customerId}")
    public ResponseEntity<Order> placeOrder(
            @PathVariable Long customerId, @RequestBody Order order) {
        return ResponseEntity.ok(service.placeOrder(customerId, order));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getOrders(@PathVariable Long customerId) {
        return ResponseEntity.ok(service.getOrdersByCustomer(customerId));
    }
}
