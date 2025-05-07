package com.FinansMate.FinansMate.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "savings_goals")
@Getter
public class SavingsGoal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String goalName;

  private BigDecimal targetAmount;
  private BigDecimal currentAmount;

  private LocalDate dueDate;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private MyUser user;
}
