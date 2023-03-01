package io.deneb.customer.service;

import io.deneb.customer.controller.CustomerRegistration;
import io.deneb.customer.model.Customer;
import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
  public void register(CustomerRegistration registration) {
    Customer customer = Customer.builder()
      .firstName(registration.firstName())
      .lastName(registration.lastName())
      .email(registration.email())
      .build();
  }
}
