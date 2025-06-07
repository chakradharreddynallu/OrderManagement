package com.orderManagement.demo.dto;

public class OrderDTO {

    private Long id;
    private String product;
    private Integer quantity;
    private Long customerId;

    public OrderDTO() {
    }

    public OrderDTO(Long id, String product, Integer quantity, Long customerId) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.customerId = customerId;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
