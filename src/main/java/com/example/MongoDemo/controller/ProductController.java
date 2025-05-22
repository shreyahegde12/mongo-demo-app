package com.example.MongoDemo.controller;

import com.example.MongoDemo.entity.Product;
import com.example.MongoDemo.repository.ProductRepository;
import com.example.MongoDemo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Products API", description = "Operations related to products")
public class ProductController {
    final private ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @Operation(summary = "Create new product")
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.saveProduct(product));
    }

    @Operation(summary = "Display all products")
    @Description("Returns a list of products")
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(this.productService.getAllProducts());
    }

    @Operation(summary = "Create product by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id){
        Product product = this.productService.getProductById(id).orElseThrow();
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Update product by ID")
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product){
        this.productService.getProductById(id).orElseThrow();
        product.setId(id);
        return ResponseEntity.ok(this.productService.saveProduct(product));
    }

    @Operation(summary = "Delete product by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id){
        this.productService.getProductById(id).orElseThrow();
        this.productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
