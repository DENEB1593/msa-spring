package io.deneb.notification.rabbitmq;

import io.deneb.clients.notification.NotificationRequest;
import io.deneb.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class NotificationConsumer {

  private final NotificationService notificationService;

  // Queue의 payload를 소비(consume) 한다.
  @RabbitListener(queues = "${rabbitmq.queues.notification}")
  public void consume(NotificationRequest notificationRequest) {
    log.info("Consumed {} from Queue", notificationRequest);
    notificationService.send(notificationRequest);
  }

}

