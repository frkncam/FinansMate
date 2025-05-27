package com.FinansMate.FinansMate.service.savings_goal;
import com.FinansMate.FinansMate.dto.savings_goal.SavingsGoalRequest;
import com.FinansMate.FinansMate.dto.savings_goal.SavingsGoalResponse;
import com.FinansMate.FinansMate.mapper.SavingsGoalMapper;
import com.FinansMate.FinansMate.model.MyUser;
import com.FinansMate.FinansMate.model.SavingsGoal;
import com.FinansMate.FinansMate.repository.UserRepository;
import com.FinansMate.FinansMate.repository.SavingsGoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class SavingsGoalServiceImpl implements SavingsGoalService {
    private final SavingsGoalRepository savingsGoalRepository;
    private final UserRepository userRepository;
    private final SavingsGoalMapper savingsGoalMapper;

    @Override
    public void createSavingGoal(SavingsGoalRequest request, String username) {
        MyUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("Kullanıcı bulunamadı");
        }

        SavingsGoal goal = savingsGoalMapper.toEntity(request, user);
        savingsGoalRepository.save(goal);
    }

    @Override
    public List<SavingsGoalResponse> getSavingGoals(String username) {
        MyUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("Kullanıcı bulunamadı");
        }

        return savingsGoalRepository.findByUserId(user.getId())
                .stream()
                .map(savingsGoalMapper::toResponse)
                .toList();
    }
}
