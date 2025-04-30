package com.FinansMate.FinansMate.service.user;

import com.FinansMate.FinansMate.dto.user.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  void save(RegisterRequest userRequest);
}
