package com.service.shop.microserviceshop.service;

import com.service.shop.microserviceshop.entity.Category;
import com.service.shop.microserviceshop.entity.Product;
import com.service.shop.microserviceshop.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceMockTest {

    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        Product computer = Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .price(12.5D)
                .stock(5D)
                .build();
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(computer));
        Mockito.lenient().when(productRepository.save(computer)).thenReturn(computer);
    }

    @Test
    public void whenValidGetId_thenReturnProduct(){
        Product productFound = productService.getProduct(1L);
        Assertions.assertThat(productFound.getName()).isEqualTo("computer");
    }

    @Test
    public void whenValidUpdateStock_thenReturnNewStock(){
        Product newSock = productService.updateStock(1L, 7D);
        Assertions.assertThat(newSock.getStock()).isEqualTo(12D);
    }

}
