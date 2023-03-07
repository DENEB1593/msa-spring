package io.deneb.amqp.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitMQConfig {

  private final ConnectionFactory connectionFactory;

  public RabbitMQConfig(ConnectionFactory connectionFactory) {
    this.connectionFactory = connectionFactory;
  }

  @Bean
  @Primary
  public AmqpTemplate amqpTemplate() {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(messageConverter());
    return rabbitTemplate;
  }

  @Bean
  public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(MessageConverter messageConverter) {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setMessageConverter(messageConverter());
    return factory;
  }

  @Bean
  public MessageConverter messageConverter() {
    Jackson2JsonMessageConverter messageConverter =
      new Jackson2JsonMessageConverter();
    return messageConverter;
  }

}
