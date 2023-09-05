package com.service.shop.microserviceshop.service;

import com.service.shop.microserviceshop.entity.InvoiceItem;
import com.service.shop.microserviceshop.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> findInvoiceAll();

    Invoice createInvoice(Invoice invoice);
    Invoice updateInvoice(Invoice invoice);
    Invoice deleteInvoice(Invoice invoice);

    Invoice getInvoice(Long id);
}
