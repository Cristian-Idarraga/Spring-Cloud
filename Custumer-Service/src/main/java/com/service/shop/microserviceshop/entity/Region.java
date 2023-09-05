package com.service.shop.microserviceshop.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tbl_regions")
@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
