package com.FinansMate.FinansMate.controller.budget;

import com.FinansMate.FinansMate.dto.budget.BudgetRequest;
import com.FinansMate.FinansMate.dto.budget.BudgetResponse;
import com.FinansMate.FinansMate.service.budget.BudgetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/budgets")
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    @PostMapping
    public void createBudget(@RequestBody @Valid BudgetRequest request) {
        budgetService.createBudget(request);
    }

    @GetMapping
    public List<BudgetResponse> getBudgets(Principal principal) {
        return budgetService.getUserBudgets(principal.getName());
    }
}