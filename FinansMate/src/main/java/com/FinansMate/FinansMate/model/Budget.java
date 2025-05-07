package com.FinansMate.FinansMate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "budgets")
@Getter
@Setter
public class Budget extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int month;
  private int year;

  private BigDecimal totalBudget;
  private BigDecimal totalSpent;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private MyUser user;
}
