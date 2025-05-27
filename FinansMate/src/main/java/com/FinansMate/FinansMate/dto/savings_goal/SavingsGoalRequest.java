package com.FinansMate.FinansMate.dto.savings_goal;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class SavingsGoalRequest {
    private String goalName;
    private BigDecimal targetAmount;
    private BigDecimal currentAmount;
    private LocalDate dueDate;
    private Long userId;
}
