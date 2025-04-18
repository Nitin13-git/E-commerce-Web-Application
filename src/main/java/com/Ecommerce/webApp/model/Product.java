package com.Ecommerce.webApp.model;

import java.util.UUID;

public class Product {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", stock=" + stock +
                '}';
    }

    private String category;
    private String description;
    private double price;
    private String color;
    private int stock;

    public Product(String name, String category, String description,
                   double price, String color, int stock) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.color = color;
        this.stock = stock;
    }

    // -- Getters & Setters --

    public String getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}

