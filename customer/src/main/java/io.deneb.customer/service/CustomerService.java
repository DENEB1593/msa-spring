package io.deneb.customer.service;

import io.deneb.customer.controller.CustomerRegistration;
import io.deneb.customer.model.Customer;
import io.deneb.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(
  CustomerRepository customerRepository) {
  public void register(CustomerRegistration registration) {
    Customer customer = Customer.builder()
      .firstName(registration.firstName())
      .lastName(registration.lastName())
      .email(registration.email())
      .build();

    customerRepository.save(customer);
  }
}
