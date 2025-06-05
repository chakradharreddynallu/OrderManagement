package com.orderManagement.demo.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@Table(name = "orders") // 'order' is a reserved keyword in SQL
//@RequiredArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
