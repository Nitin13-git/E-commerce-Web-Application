package com.Ecommerce.webApp.model;

import java.util.UUID;

public class Order {
    private String id;
    private String productId;
    private int quantity;
    private String customerName;

    public Order(String productId, int quantity, String customerName) {
        this.id = UUID.randomUUID().toString();
        this.productId = productId;
        this.quantity = quantity;
        this.customerName = customerName;
    }

    // -- Getters & Setters --

    public String getId() { return id; }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
}

