package com.mongo.demo.service;


import com.mongo.demo.model.Product;
import com.mongo.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts()              { return repository.findAll(); }
    public Optional<Product> getById(String id)       { return repository.findById(id); }
    public Product create(Product product)             { return repository.save(product); }
    public void delete(String id)                      { repository.deleteById(id); }
}