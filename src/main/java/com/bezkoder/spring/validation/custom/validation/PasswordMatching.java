package com.bezkoder.spring.validation.custom.validation;

import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = PasswordMatchingValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatching {
  String password();

  String confirmPassword();

  String message() default "Passwords must match!";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  @Target({ ElementType.TYPE })
  @Retention(RetentionPolicy.RUNTIME)
  @interface List {
    PasswordMatching[] value();
  }
}
