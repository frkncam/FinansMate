package com.FinansMate.FinansMate.service.budget;

import com.FinansMate.FinansMate.dto.budget.BudgetRequest;
import com.FinansMate.FinansMate.dto.budget.BudgetResponse;

import java.util.List;

public interface BudgetService {

    void createBudget(BudgetRequest request);

    List<BudgetResponse> getUserBudgets(String username);
}
