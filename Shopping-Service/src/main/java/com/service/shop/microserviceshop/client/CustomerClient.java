package com.service.shop.microserviceshop.client;


import com.service.shop.microserviceshop.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "customer-service", fallback = CustomerHystrixFallbackFactory.class)
@Component
public interface CustomerClient {

    @GetMapping(value = "/customers/{id}")
    ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);
}
