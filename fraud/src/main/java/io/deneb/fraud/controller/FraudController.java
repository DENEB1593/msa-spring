package io.deneb.fraud.controller;

import io.deneb.fraud.FraudCheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(
  FraudCheckService fraudCheckService) {


  @GetMapping("{customerId}")
  public FraudCheckResponse isFraudster(
    @PathVariable("customerId") Integer customerId) {
    boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
    return new FraudCheckResponse(isFraudulentCustomer);
  }


}
