package com.FinansMate.FinansMate.mapper;

import com.FinansMate.FinansMate.dto.savings_goal.SavingsGoalRequest;
import com.FinansMate.FinansMate.dto.savings_goal.SavingsGoalResponse;
import com.FinansMate.FinansMate.model.MyUser;
import com.FinansMate.FinansMate.model.SavingsGoal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SavingsGoalMapper {
    SavingsGoalMapper INSTANCE = Mappers.getMapper(SavingsGoalMapper.class);

    SavingsGoalResponse toResponse(SavingsGoal savingsGoal);

    @Mapping(target = "user", source = "user")
    SavingsGoal toEntity(SavingsGoalRequest request, MyUser user);
}