package com.FinansMate.FinansMate.service.budget;

import com.FinansMate.FinansMate.dto.budget.BudgetRequest;
import com.FinansMate.FinansMate.dto.budget.BudgetResponse;
import com.FinansMate.FinansMate.mapper.BudgetMapper;
import com.FinansMate.FinansMate.model.Budget;
import com.FinansMate.FinansMate.model.MyUser;
import com.FinansMate.FinansMate.repository.BudgetRepository;
import com.FinansMate.FinansMate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;
    private final UserRepository userRepository;
    private final BudgetMapper budgetMapper;

    @Override
    public void createBudget(BudgetRequest request) {
        // Username ile kullanıcıyı alıyoruz, Optional ile sarıyoruz
        MyUser user = Optional.ofNullable(userRepository.findByUsername(request.getUsername()))
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));  // Eğer kullanıcı null ise hata fırlatıyoruz

        Budget budget = budgetMapper.toEntity(request, user);  // DTO'dan entity'ye dönüştürme
        budgetRepository.save(budget);  // Veritabanına kaydetme
    }

    @Override
    public List<BudgetResponse> getUserBudgets(String username) {
        // Username ile kullanıcıyı alıyoruz, Optional ile sarıyoruz
        MyUser user = Optional.ofNullable(userRepository.findByUsername(username))
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));  // Eğer kullanıcı null ise hata fırlatıyoruz

        return budgetRepository.findByUserId(user.getId())  // Kullanıcıya ait bütçeleri alıyoruz
                .stream()
                .map(budgetMapper::toResponse)  // Entity'yi DTO'ya dönüştürme
                .toList();
    }
}