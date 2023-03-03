package io.deneb.notification.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Notification {

  @Id
  @SequenceGenerator(
    name = "notification_id_seq",
    sequenceName = "notification_id_seq"
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "notification_id_seq"
  )
  private Integer notificationId;
  private Integer toCustomerId;
  private String toCustomerEmail;
  private String sender;
  private String message;
  private LocalDateTime sentAt;
}