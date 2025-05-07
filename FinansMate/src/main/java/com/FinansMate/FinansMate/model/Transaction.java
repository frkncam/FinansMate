package com.FinansMate.FinansMate.model;

import com.FinansMate.FinansMate.enums.Currency;
import com.FinansMate.FinansMate.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BigDecimal amount;

  @Enumerated(EnumType.STRING)
  private TransactionType type;

  private LocalDate date;

  private String description;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private MyUser user;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Currency currency;
}
