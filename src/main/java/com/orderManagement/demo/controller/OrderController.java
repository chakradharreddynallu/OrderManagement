//package com.orderManagement.demo.controller;
//
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.orderManagement.demo.model.Order;
//import com.orderManagement.demo.service.OrderService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import jakarta.validation.Valid;
//
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/orders")
//public class OrderController {
//    @Autowired
//    private OrderService service;
//
//    @PostMapping("/{customerId}")
//    public ResponseEntity<Order> placeOrder(
//            @PathVariable Long customerId, @Valid @RequestBody Order order) {
//        return ResponseEntity.ok(service.placeOrder(customerId, order));
//    }
//
//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<List<Order>> getOrders(@PathVariable Long customerId) {
//        return ResponseEntity.ok(service.getOrdersByCustomer(customerId));
//    }
//}
//

package com.orderManagement.demo.controller;

import com.orderManagement.demo.dto.OrderDTO;
import com.orderManagement.demo.service.OrderService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/{customerId}")
    public ResponseEntity<OrderDTO> placeOrder(
            @PathVariable Long customerId, @Valid @RequestBody OrderDTO orderDTO) {
        OrderDTO createdOrder = service.placeOrder(customerId, orderDTO);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderDTO>> getOrders(@PathVariable Long customerId) {
        List<OrderDTO> orders = service.getOrdersByCustomer(customerId);
        return ResponseEntity.ok(orders);
    }
}
