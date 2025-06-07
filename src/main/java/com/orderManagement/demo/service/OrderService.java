//package com.orderManagement.demo.service;
//
//import com.orderManagement.demo.model.Customer;
//import com.orderManagement.demo.model.Order;
//import com.orderManagement.demo.repository.OrderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.*;
//import com.orderManagement.demo.repository.CustomerRepository;
//
//import java.util.List;
//@Service
//
//public class OrderService {
//    @Autowired
//    private OrderRepository orderRepo;
//    @Autowired
//    private CustomerRepository customerRepo;
//
//    public Order placeOrder(Long customerId, Order order) {
//        Customer customer = customerRepo.findById(customerId).orElseThrow();
//        order.setCustomer(customer);
//        return orderRepo.save(order);
//    }
//
//    public List<Order> getOrdersByCustomer(Long customerId) {
//        return orderRepo.findByCustomerId(customerId);
//    }
//}
package com.orderManagement.demo.service;

import com.orderManagement.demo.dto.OrderDTO;
import com.orderManagement.demo.model.Order;
import com.orderManagement.demo.model.Customer;
import com.orderManagement.demo.repository.OrderRepository;
import com.orderManagement.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CustomerRepository customerRepo;

    public OrderDTO placeOrder(Long customerId, OrderDTO orderDTO) {
        Customer customer = customerRepo.findById(customerId).orElseThrow();

        Order order = new Order();
        order.setProduct(orderDTO.getProduct());
        order.setQuantity(orderDTO.getQuantity());
        order.setCustomer(customer);

        Order savedOrder = orderRepo.save(order);

        return convertToOrderDTO(savedOrder);
    }

    public List<OrderDTO> getOrdersByCustomer(Long customerId) {
        List<Order> orders = orderRepo.findByCustomerId(customerId);
        return orders.stream()
                .map(this::convertToOrderDTO)
                .collect(Collectors.toList());
    }

    private OrderDTO convertToOrderDTO(Order order) {
        return new OrderDTO(order.getId(), order.getProduct(), order.getQuantity(), order.getCustomer().getId());
    }
}
