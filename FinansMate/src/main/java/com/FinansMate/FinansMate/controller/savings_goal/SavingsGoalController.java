package com.FinansMate.FinansMate.controller.savings_goal;

import com.FinansMate.FinansMate.dto.savings_goal.SavingsGoalRequest;
import com.FinansMate.FinansMate.dto.savings_goal.SavingsGoalResponse;
import com.FinansMate.FinansMate.service.savings_goal.SavingsGoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/saving-goals")
@RequiredArgsConstructor
public class SavingsGoalController {
    private final SavingsGoalService savingsGoalService;

    @PostMapping
    public ResponseEntity<Void> createSavingGoal(
            @RequestBody SavingsGoalRequest request,
            @AuthenticationPrincipal UserDetails userDetails) {
        savingsGoalService.createSavingGoal(request, userDetails.getUsername());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<SavingsGoalResponse>> getSavingGoals(
            @AuthenticationPrincipal UserDetails userDetails) {
        List<SavingsGoalResponse> goals = savingsGoalService.getSavingGoals(userDetails.getUsername());
        return ResponseEntity.ok(goals);
    }
}
