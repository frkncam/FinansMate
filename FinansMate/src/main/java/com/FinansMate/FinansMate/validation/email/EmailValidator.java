package com.FinansMate.FinansMate.validation.email;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

  private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

  @Override
  public void initialize(ValidEmail constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
    if (email == null || email.isEmpty()) {
      return false;
    }
    return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
  }
}
