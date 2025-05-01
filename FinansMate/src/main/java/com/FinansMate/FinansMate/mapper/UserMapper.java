package com.FinansMate.FinansMate.mapper;

import com.FinansMate.FinansMate.dto.user.RegisterRequest;
import com.FinansMate.FinansMate.model.MyUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  MyUser userRequestToUser(RegisterRequest userRequest);
}
