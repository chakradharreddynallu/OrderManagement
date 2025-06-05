package com.orderManagement.demo.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.orderManagement.demo.model.Order;
import com.orderManagement.demo.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

