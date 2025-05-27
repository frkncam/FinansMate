package com.FinansMate.FinansMate.mapper;

import com.FinansMate.FinansMate.dto.budget.BudgetRequest;
import com.FinansMate.FinansMate.dto.budget.BudgetResponse;
import com.FinansMate.FinansMate.model.Budget;
import com.FinansMate.FinansMate.model.MyUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BudgetMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "totalSpent", constant = "0")
    @Mapping(target = "user", source = "user")
    Budget toEntity(BudgetRequest request, MyUser user);

    BudgetResponse toResponse(Budget budget);
}
