//package com.orderManagement.demo.controller;
//
//import com.orderManagement.demo.model.Customer;
//import com.orderManagement.demo.service.CustomerService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;  // Needed for @RestController, @RequestMapping, etc.
//
//@RestController
//@RequestMapping({"/", "/customers"})
//public class CustomerController {
//    @Autowired
//    private CustomerService service;
//
//    @PostMapping
//    public ResponseEntity<Customer> create(@Valid @RequestBody Customer customer) {
//        return ResponseEntity.ok(service.createCustomer(customer));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Customer> get(@PathVariable Long id) {
//        return ResponseEntity.ok(service.getCustomer(id));
//    }
//}

package com.orderManagement.demo.controller;

import com.orderManagement.demo.dto.CustomerDTO;
import com.orderManagement.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping({"/", "/customers"})
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = service.createCustomer(customerDTO);
        return ResponseEntity.ok(createdCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> get(@PathVariable Long id) {
        CustomerDTO customerDTO = service.getCustomer(id);
        return ResponseEntity.ok(customerDTO);
    }
}
