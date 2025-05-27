package com.FinansMate.FinansMate.dto.budget;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetRequest {

    @NotNull
    private String username;

    @NotNull
    private int month;

    @NotNull
    private int year;

    @NotNull
    private BigDecimal totalBudget;

    @NotNull
    private Long userId;
}