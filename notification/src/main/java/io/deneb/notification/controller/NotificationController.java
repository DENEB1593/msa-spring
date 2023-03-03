package io.deneb.notification.controller;

import io.deneb.clients.notification.NotificationRequest;
import io.deneb.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
public record NotificationController(
  NotificationService notificationService
) {

  @PostMapping
  public void send(@RequestBody NotificationRequest notificationRequest) {
    log.info("notification send request : {}", notificationRequest);
    notificationService.send(notificationRequest);
  }


}
