package com.FinansMate.FinansMate.service.user;

import com.FinansMate.FinansMate.dto.user.RegisterRequest;
import com.FinansMate.FinansMate.enums.Role;
import com.FinansMate.FinansMate.exception.email.EmailAlreadyExistsException;
import com.FinansMate.FinansMate.mapper.UserMapper;
import com.FinansMate.FinansMate.model.MyUser;
import com.FinansMate.FinansMate.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void save(RegisterRequest userRequest) {

    if (userRepository.existsByEmail(userRequest.getEmail())) {
      throw new EmailAlreadyExistsException("Email already exists");
    }

    MyUser user = UserMapper.Instance.userRequestToUser(userRequest);
    user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
    user.setRole(Role.USER);

    userRepository.save(user);
  }
}
