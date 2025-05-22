package com.example.MongoDemo.repository;

import com.example.MongoDemo.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
