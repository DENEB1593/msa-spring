package io.deneb.notification.repository;

import io.deneb.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository
  extends JpaRepository<Notification, Integer> {
}
