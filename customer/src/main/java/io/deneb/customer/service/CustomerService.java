package io.deneb.customer.service;

import io.deneb.amqp.config.RabbitMQMessageProducer;
import io.deneb.clients.fraud.FraudCheckResponse;
import io.deneb.clients.fraud.FraudClient;
import io.deneb.clients.notification.NotificationRequest;
import io.deneb.customer.controller.CustomerRegistration;
import io.deneb.customer.model.Customer;
import io.deneb.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(
  CustomerRepository customerRepository,
  RestTemplate restTemplate,
  FraudClient fraudClient,
  RabbitMQMessageProducer producer) {

  public void register(CustomerRegistration registration) {
    Customer customer = Customer.builder()
      .firstName(registration.firstName())
      .lastName(registration.lastName())
      .email(registration.email())
      .build();

    customerRepository.saveAndFlush(customer);

    // Fraud Client
    FraudCheckResponse fraudCheckResponse =
      fraudClient.isFraudster(customer.getId());

    // 사기여부 체크
    if (fraudCheckResponse.isFraudster()) {
      throw new IllegalStateException("fraudster");
    }

    NotificationRequest notificationRequest = new NotificationRequest(
      customer.getId(),
      customer.getEmail(),
      String.format("Hello %s, Welcome to service", customer.getFirstName())
    );

    // send to rabbitMQ
    producer.publish(
      notificationRequest,
      "internal.exchange",
      "internal.notification.routing-key"
    );
  }
}
