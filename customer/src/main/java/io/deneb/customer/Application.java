package io.deneb.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
  scanBasePackages = {
    "io.deneb.customer",
    "io.deneb.amqp.config"
  }
)
@EnableEurekaClient
@EnableFeignClients(
  basePackages = "io.deneb.clients"
)
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
