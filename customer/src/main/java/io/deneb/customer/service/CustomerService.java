package io.deneb.customer.service;

import io.deneb.clients.fraud.FraudCheckResponse;
import io.deneb.clients.fraud.FraudClient;
import io.deneb.customer.controller.CustomerRegistration;
import io.deneb.customer.model.Customer;
import io.deneb.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(
  CustomerRepository customerRepository,
  RestTemplate restTemplate,
  FraudClient fraudClient) {

  public void register(CustomerRegistration registration) {
    Customer customer = Customer.builder()
      .firstName(registration.firstName())
      .lastName(registration.lastName())
      .email(registration.email())
      .build();

    customerRepository.saveAndFlush(customer);
    // TODO: check if fraudster

    // To Client
    FraudCheckResponse fraudCheckResponse =
      fraudClient.isFraudster(customer.getId());

    if (fraudCheckResponse.isFraudster()) {
      throw new IllegalStateException("fraudster");
    }


    // todo: send notification
  }
}
