package com.service.shop.microserviceshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_products")
@AllArgsConstructor @NoArgsConstructor @Builder @Data @ToString(exclude = {"category"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "El nombre no debe ser vacio")
    private String name;
    private String description;
    @Positive(message = "stock debe ser mayor a cero")
    private Double stock;
    private Double price;
    private String status;
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @NotNull(message = "la categoria no puede estar vacia")
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;
}
