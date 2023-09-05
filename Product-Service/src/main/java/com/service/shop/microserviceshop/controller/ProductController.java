package com.service.shop.microserviceshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.shop.microserviceshop.entity.Product;
import com.service.shop.microserviceshop.service.ProductService;
import com.service.shop.microserviceshop.util.Constants;
import com.service.shop.microserviceshop.util.Util;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> listProduct(){
        List<Product> products = productService.listAllProduct();
        if(products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(name = "id") Long id){
        Product product = productService.getProduct(id);
        if(null == product){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Util.formatMessage(bindingResult));
        }
        Product productCreated = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productCreated);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product productUpdated = productService.updateProduct(product);
        if(null == productUpdated){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productUpdated);
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<Product> UpdateStockproduct(@PathVariable Long id,@RequestParam(name = "quantity", defaultValue = "1") Double quantity){
        Product productUpdated = productService.updateStock(id, quantity);
        if(null == productUpdated){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        Product productDeleted = productService.deleteProduct(id);
        if(null == productDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDeleted);
    }

}
