package io.deneb.notification;

import io.deneb.amqp.config.RabbitMQMessageProducer;
import io.deneb.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
  scanBasePackages = {
    "io.deneb.notification.config",
    "io.deneb.amqp.config"
  }
)
@EnableEurekaClient
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer,
                                      NotificationConfig notificationConfig) {
    return args -> {
      producer.publish(
        new Person("deneb", 30),
        notificationConfig.getInternalExchange(),
        notificationConfig.getInternalNotificationRoutingKey()
      );
    };
  }

  record Person(String name, int age) { }

}