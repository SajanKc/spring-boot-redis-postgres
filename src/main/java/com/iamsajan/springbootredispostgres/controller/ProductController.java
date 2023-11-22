package com.iamsajan.springbootredispostgres.controller;

import com.iamsajan.springbootredispostgres.model.Product;
import com.iamsajan.springbootredispostgres.service.ProductService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    @Cacheable(value = "product", key = "#id")
    public Product getProductById(@PathVariable String id) {
        return this.productService.getProductById(id);
    }

    @PostMapping
    @CachePut(value = "product", key = "#product.id")
    public Product saveProduct(@RequestBody Product product) {
        return this.productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    @CachePut(value = "product", key = "#id")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        return this.productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "product", key = "#id")
    public String deleteProduct(@PathVariable String id) {
        return this.productService.deleteProduct(id);
    }
}
