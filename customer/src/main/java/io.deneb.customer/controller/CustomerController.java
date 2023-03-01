package io.deneb.customer.controller;

import io.deneb.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(
  CustomerService customerService
) {

  @PostMapping
  public void register(@RequestBody CustomerRegistration registration) {
    log.info("new customer registration : {}", registration);
    customerService.register(registration);
  }
}
