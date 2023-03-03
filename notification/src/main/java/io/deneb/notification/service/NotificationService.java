package io.deneb.notification.service;

import io.deneb.clients.notification.NotificationRequest;
import io.deneb.notification.model.Notification;
import io.deneb.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(
  NotificationRepository notificationRepository
) {
  public void send(NotificationRequest notificationRequest) {
    Notification notification = Notification.builder()
      .toCustomerId(notificationRequest.toCustomerId())
      .toCustomerEmail(notificationRequest.toCustomerEmail())
      .sender("deneb")
      .message(notificationRequest.message())
      .sentAt(LocalDateTime.now())
      .build();
    notificationRepository.save(notification);
  }
}
