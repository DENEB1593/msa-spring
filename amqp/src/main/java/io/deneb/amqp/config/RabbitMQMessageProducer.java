package io.deneb.amqp.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RabbitMQMessageProducer {

  private final AmqpTemplate template;

  public void publish(Object payload, String exchange, String routingKey) {
    log.info("Publishing to {} using routingKey {}, Payload: {}", exchange, routingKey, payload);
    template.convertAndSend(exchange, routingKey, payload);
    log.info("Published to {} using routingKey {}, Payload: {}", exchange, routingKey, payload);
  }

}
