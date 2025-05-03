package com.FinansMate.FinansMate.dto.user;

import com.FinansMate.FinansMate.enums.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
  private String token;
  private String email;
  private Role role;
}
