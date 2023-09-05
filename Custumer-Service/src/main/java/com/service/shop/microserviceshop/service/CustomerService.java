package com.service.shop.microserviceshop.service;

import com.service.shop.microserviceshop.entity.Region;
import com.service.shop.microserviceshop.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findCustomerAll();
    List<Customer> findCustomersByRegion(Region region);

    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer deleteCustomer(Customer customer);
    Customer getCustomer(Long id);
}
