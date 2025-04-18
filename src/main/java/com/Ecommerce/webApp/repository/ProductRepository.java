package com.Ecommerce.webApp.repository;

import com.Ecommerce.webApp.model.Product;
import java.util.*;

public class ProductRepository {
    private static final Map<String, Product> productMap = new HashMap<>();

    public static void addProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    public static List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    public static Optional<Product> getById(String id) {
        return Optional.ofNullable(productMap.get(id));
    }

    public static boolean deleteById(String id) {
        return productMap.remove(id) != null;
    }

    // <— This is the method your service is calling!
    public static List<Product> searchByKeyword(String keyword) {
        List<Product> results = new ArrayList<>();
        String key = keyword.toLowerCase();
        for (Product p : productMap.values()) {
            if (p.getName().toLowerCase().contains(key) ||
                    p.getCategory().toLowerCase().contains(key)) {
                results.add(p);
            }
        }
        return results;
    }
}


