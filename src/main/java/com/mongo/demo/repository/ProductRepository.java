package com.mongo.demo.repository;


import com.mongo.demo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    // MongoRepository gives you: findAll, findById, save, deleteById, etc.
}