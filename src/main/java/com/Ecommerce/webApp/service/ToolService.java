package com.Ecommerce.webApp.service;

import com.Ecommerce.webApp.model.Order;
import com.Ecommerce.webApp.model.Product;
import com.Ecommerce.webApp.repository.OrderRepository;
import com.Ecommerce.webApp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolService {
    public List<Product> searchProduct(String keyword) {
        // Now resolves to the correct method
        return ProductRepository.searchByKeyword(keyword);
    }

    public Order bookProduct(String productId, int quantity, String customerName) {
        Product product = ProductRepository.getById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getStock() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }
        product.setStock(product.getStock() - quantity);

        Order order = new Order(productId, quantity, customerName);
        OrderRepository.addOrder(order);
        return order;
    }
}

