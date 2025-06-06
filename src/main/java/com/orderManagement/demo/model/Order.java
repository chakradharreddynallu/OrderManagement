package com.orderManagement.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.*;
@Entity
@Data
@Table(name = "orders") // 'order' is a reserved keyword in SQL
//@RequiredArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name cannot be blank")
    private String product;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull(message = "Customer must not be null")
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
