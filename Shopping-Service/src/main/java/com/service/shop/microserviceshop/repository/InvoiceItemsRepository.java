package com.service.shop.microserviceshop.repository;

import com.service.shop.microserviceshop.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {
}
