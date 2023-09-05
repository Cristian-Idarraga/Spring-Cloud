package com.service.shop.microserviceshop.repository;

import com.service.shop.microserviceshop.entity.Category;
import com.service.shop.microserviceshop.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory_thenReturnListProduct(){
        Product product = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(10D)
                .price(Double.parseDouble("1240.99"))
                .status("Created")
                .createAt(LocalDateTime.now()).build();
        productRepository.save(product);
        List<Product> founds = productRepository.findByCategory(product.getCategory());
        Assertions.assertThat(founds.size()).isEqualTo(3);
    }
}
