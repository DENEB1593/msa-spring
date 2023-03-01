package io.deneb.customer.service;

import io.deneb.customer.controller.CustomerRegistration;
import io.deneb.customer.model.Customer;
import io.deneb.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(
  CustomerRepository customerRepository,
  RestTemplate restTemplate) {

  public void register(CustomerRegistration registration) {
    Customer customer = Customer.builder()
      .firstName(registration.firstName())
      .lastName(registration.lastName())
      .email(registration.email())
      .build();

    customerRepository.saveAndFlush(customer);
    // TODO: check if fraudster
    FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
      "http://localhost:8081/api/v1/fraud-check/{customerId}",
      FraudCheckResponse.class,
      customer.getId()
    );

    if (fraudCheckResponse.isFraudster()) {
      throw new IllegalStateException("fraudster");
    }


    // todo: send notification
  }
}
