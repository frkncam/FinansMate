package com.FinansMate.FinansMate.dto.user;

import com.FinansMate.FinansMate.validation.email.ValidEmail;
import com.FinansMate.FinansMate.validation.password.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  @NotBlank
  private String username;

  @ValidEmail
  private String email;

  @ValidPassword
  private String password;
}
