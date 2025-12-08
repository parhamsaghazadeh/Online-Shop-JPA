package com.parham.online_shop.controller;

import com.parham.online_shop.entity.Product;
import com.parham.online_shop.model.Converter;
import com.parham.online_shop.model.ProductModel;
import com.parham.online_shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private Converter converter;


    @GetMapping
    public ResponseEntity<List<ProductModel>> getProduct() {
        try {
            List<Product> products = productService.getAllProducts();
            List<ProductModel> productModels = products.stream()
                    .map(converter::toModelProduct).
                    peek(System.out::println)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(productModels);
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ProductModel> getProductById(@RequestParam long id) {
        try {
            Product product = productService.getProductById(id);
            ProductModel productModels = converter.toModelProduct(product);
            return ResponseEntity.ok(productModels);
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        try {
            Product savedProduct = productService.addProduct(product);
            return ResponseEntity.ok(savedProduct);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(@RequestParam Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        try {
            productService.updateProduct(product);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
