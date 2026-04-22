package com.mongo.demo.controller;

import com.mongo.demo.model.Product;
import com.mongo.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // GET all products
    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - create product
    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.create(product);
    }

    // DELETE by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
