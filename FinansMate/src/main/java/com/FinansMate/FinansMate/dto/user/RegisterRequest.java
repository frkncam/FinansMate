package com.FinansMate.FinansMate.dto.user;

import com.FinansMate.FinansMate.validation.email.ValidEmail;
import com.FinansMate.FinansMate.validation.password.ValidPassword;
import io.swagger.v3.oas.annotations.media.Schema;
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
  @Schema(example = "Furkan ÇAM")
  private String username;

  @ValidEmail
  @Schema(example = "furkan.cam@qkare.com")
  private String email;

  @ValidPassword
  @Schema(example = "Finans123.")
  private String password;
}
