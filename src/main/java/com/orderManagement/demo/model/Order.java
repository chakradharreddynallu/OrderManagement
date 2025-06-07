package com.orderManagement.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "orders") // because 'order' is a reserved keyword in SQL
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
    private com.orderManagement.demo.model.Customer customer;

    public Order() {
    }

    public Order(Long id, String product, Integer quantity, com.orderManagement.demo.model.Customer customer) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public com.orderManagement.demo.model.Customer getCustomer() {
        return customer;
    }

    public void setCustomer(com.orderManagement.demo.model.Customer customer) {
        this.customer = customer;
    }
}
