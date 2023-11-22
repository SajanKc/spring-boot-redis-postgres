package com.iamsajan.springbootredispostgres.service;

import com.iamsajan.springbootredispostgres.model.Product;
import com.iamsajan.springbootredispostgres.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(String id) {
        log.info("Fetching product with id: {}", id);
        return this.productRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product saveProduct(Product product) {
        log.info("Saving product with id: {}", product.getId());
        return this.productRepository.save(product);
    }

    public Product updateProduct(String id, Product product) {
        log.info("Updating product with id: {}", id);
        Product existingProduct = this.productRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setCode(product.getCode());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setPrice(product.getPrice());
            return this.productRepository.save(existingProduct);
        }
        return new Product();
    }

    public String deleteProduct(String id) {
        log.info("Deleting product with id: {}", id);
        this.productRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        this.productRepository.deleteById(Long.parseLong(id));
        return "Product with id: " + id + " deleted.";
    }
}
