package com.FinansMate.FinansMate.dto.budget;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetResponse {

    private Long id;
    private int month;
    private int year;
    private BigDecimal totalBudget;
    private BigDecimal totalSpent;
}