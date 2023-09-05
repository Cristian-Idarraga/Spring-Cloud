package com.service.shop.microserviceshop.repository;

import com.service.shop.microserviceshop.entity.Category;
import com.service.shop.microserviceshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);
}
