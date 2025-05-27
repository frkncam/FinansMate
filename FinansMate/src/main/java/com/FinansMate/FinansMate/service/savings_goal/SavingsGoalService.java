package com.FinansMate.FinansMate.service.savings_goal;

import com.FinansMate.FinansMate.dto.savings_goal.SavingsGoalRequest;
import com.FinansMate.FinansMate.dto.savings_goal.SavingsGoalResponse;
import java.util.List;

public interface SavingsGoalService {
    void createSavingGoal(SavingsGoalRequest request, String username);
    List<SavingsGoalResponse> getSavingGoals(String username);
}