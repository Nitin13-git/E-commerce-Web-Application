package com.Ecommerce.webApp.util;

import com.Ecommerce.webApp.model.Product;
import com.Ecommerce.webApp.repository.ProductRepository;

import java.util.Random;

public final class SampleDataGenerator {

    private SampleDataGenerator() {
        // Private constructor to prevent instantiation
    }

    public static void generateSampleProducts(int count) {
        String[] categories = {"Electronics", "Books", "Clothing", "Home", "Toys"};
        String[] colors = {"Red", "Blue", "Green", "Black", "White"};
        String[] names = {"Gadget", "Novel", "Shirt", "Lamp", "Puzzle"};

        Random random = new Random();

        for (int i = 0; i < count; i++) {
            String name = names[random.nextInt(names.length)] + " " + (i + 1);
            String category = categories[random.nextInt(categories.length)];
            String description = "Description for " + name;
            double price = 10 + (100 - 10) * random.nextDouble();
            String color = colors[random.nextInt(colors.length)];
            int stock = random.nextInt(50) + 1;

            Product product = new Product(name, category, description, price, color, stock);
            ProductRepository.addProduct(product);
        }
    }
}
