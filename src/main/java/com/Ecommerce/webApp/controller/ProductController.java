package com.Ecommerce.webApp.controller;

import com.Ecommerce.webApp.model.Product;
import com.Ecommerce.webApp.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    // GET all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        logger.info("Fetching all products");
        List<Product> products = ProductRepository.getAllProducts();
        if (products.isEmpty()) {
            logger.info("No products found");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    // GET product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        logger.info("Fetching product with id: {}", id);
        Optional<Product> product = ProductRepository.getById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> {
                    logger.warn("Product not found with id: {}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    // POST new product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        logger.info("Creating new product: {}", product);
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            logger.error("Product name cannot be empty");
            return ResponseEntity.badRequest().build();
        }
        ProductRepository.addProduct(product);
        return ResponseEntity.ok(product);
    }

    // PUT update product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        logger.info("Updating product with id: {}", id);
        Optional<Product> existingProduct = ProductRepository.getById(id);
        
        if (existingProduct.isEmpty()) {
            logger.warn("Product not found for update with id: {}", id);
            return ResponseEntity.notFound().build();
        }

        Product product = existingProduct.get();
        // Update only non-null fields
        if (updatedProduct.getName() != null) product.setName(updatedProduct.getName());
        if (updatedProduct.getCategory() != null) product.setCategory(updatedProduct.getCategory());
        if (updatedProduct.getDescription() != null) product.setDescription(updatedProduct.getDescription());
        if (updatedProduct.getPrice() > 0) product.setPrice(updatedProduct.getPrice());
        if (updatedProduct.getColor() != null) product.setColor(updatedProduct.getColor());
        if (updatedProduct.getStock() >= 0) product.setStock(updatedProduct.getStock());

        return ResponseEntity.ok(product);
    }

    // DELETE product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        logger.info("Deleting product with id: {}", id);
        boolean deleted = ProductRepository.deleteById(id);
        if (!deleted) {
            logger.warn("Product not found for deletion with id: {}", id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
} 