package com.dh.billservice.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bills")
@Data
public class Bill {

  @Id
  @SequenceGenerator(name = "expenseSequence",sequenceName = "expenseSequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenseSequence")
  private Long idBill;

  private Date billingDate;

  private String customerBill;

  private String productBill;

  private Double totalPrice;

}
