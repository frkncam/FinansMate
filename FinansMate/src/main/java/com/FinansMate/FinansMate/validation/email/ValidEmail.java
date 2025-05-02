package com.FinansMate.FinansMate.validation.email;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmail {

  String message() default "Şifre en az 8 karakter olmalı, büyük harf, küçük harf, sayı ve özel karakter içermelidir.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
