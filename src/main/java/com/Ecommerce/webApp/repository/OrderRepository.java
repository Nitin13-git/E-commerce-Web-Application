package com.Ecommerce.webApp.repository;

import com.Ecommerce.webApp.model.Order;
import java.util.*;

public class OrderRepository {
    // in‑memory storage
    private static final Map<String, Order> orderMap = new HashMap<>();

    /**
     * Save a new Order into the map.
     */
    public static void addOrder(Order order) {
        orderMap.put(order.getId(), order);
    }

    /**
     * Retrieve all stored orders.
     */
    public static List<Order> getAllOrders() {
        return new ArrayList<>(orderMap.values());
    }

    /**
     * Find one order by its UUID id.
     */
    public static Optional<Order> getById(String id) {
        return Optional.ofNullable(orderMap.get(id));
    }
}
