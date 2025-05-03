package com.FinansMate.FinansMate.service.user;

import com.FinansMate.FinansMate.config.jwt.JwtUtils;
import com.FinansMate.FinansMate.dto.user.LoginRequest;
import com.FinansMate.FinansMate.dto.user.LoginResponse;
import com.FinansMate.FinansMate.dto.user.RegisterRequest;
import com.FinansMate.FinansMate.enums.Role;
import com.FinansMate.FinansMate.exception.email.EmailAlreadyExistsException;
import com.FinansMate.FinansMate.exception.user.UserNotFoundException;
import com.FinansMate.FinansMate.mapper.UserMapper;
import com.FinansMate.FinansMate.model.MyUser;
import com.FinansMate.FinansMate.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtils jwtUtils;

  @Override
  public void save(RegisterRequest userRequest) {

    if (userRepository.existsByEmail(userRequest.getEmail())) {
      throw new EmailAlreadyExistsException("Email already exists");
    }

    MyUser user = UserMapper.INSTANCE.userRequestToUser(userRequest);
    user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
    user.setRole(Role.USER);

    userRepository.save(user);
  }

  @Override
  public LoginResponse login(LoginRequest loginRequest) {
    String email = loginRequest.getEmail().toLowerCase();

    MyUser user =
        userRepository
            .findByEmailIgnoreCase(email)
            .orElseThrow(() -> new UserNotFoundException("User not found"));

    if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
      throw new RuntimeException("Invalid password");
    }

    Authentication authentication =
        new UsernamePasswordAuthenticationToken(
            user.getEmail(),
            null,
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole())));

    String token = jwtUtils.generateToken(authentication);

    return new LoginResponse(token, user.getEmail(), user.getRole());
  }
}
