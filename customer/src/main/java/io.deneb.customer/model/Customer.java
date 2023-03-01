package io.deneb.customer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

  @Id
  @SequenceGenerator(
    name= "customer_seq",
    sequenceName = "customer_seq",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "customer_seq"
  )
  private Integer id;

  private String firstName;

  private String lastName;

  private String email;

}
