package com.FinansMate.FinansMate.controller.user;

import com.FinansMate.FinansMate.dto.user.LoginRequest;
import com.FinansMate.FinansMate.dto.user.LoginResponse;
import com.FinansMate.FinansMate.dto.user.RegisterRequest;
import com.FinansMate.FinansMate.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {

  private final UserService userService;

  @PostMapping("/register")
  public String register(@RequestBody @Valid RegisterRequest registerRequest) {
    userService.save(registerRequest);
    return "User registered successfully";
  }

  @PostMapping("/login")
  public LoginResponse login(@RequestBody LoginRequest loginRequest) {
    return userService.login(loginRequest);
  }
}
