package com.example.MongoDemo.service;

import com.example.MongoDemo.entity.Product;
import com.example.MongoDemo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    final private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public Product saveProduct(Product product){
        return this.productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    public Optional<Product> getProductById(String id){
        return this.productRepository.findById(id);
    }

    public void deleteProductById(String id){
        this.productRepository.deleteById(id);
    }
}
