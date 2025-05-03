package com.FinansMate.FinansMate.service.user;

import com.FinansMate.FinansMate.dto.user.LoginRequest;
import com.FinansMate.FinansMate.dto.user.LoginResponse;
import com.FinansMate.FinansMate.dto.user.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  void save(RegisterRequest userRequest);

  LoginResponse login(LoginRequest loginRequest);
}
