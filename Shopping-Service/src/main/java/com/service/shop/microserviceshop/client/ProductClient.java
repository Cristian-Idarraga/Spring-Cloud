package com.service.shop.microserviceshop.client;

import com.service.shop.microserviceshop.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/products")
@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Product> getProduct(@PathVariable("id") Long id);

    @GetMapping(value = "/{id}/stock")
    ResponseEntity<Product> updateStockProduct(@PathVariable  Long id ,@RequestParam(name = "quantity") Double quantity);
    }
