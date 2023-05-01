package com.bezkoder.spring.validation.custom.validation;

import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = StrongPasswordValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StrongPassword {
  String message() default "Must be 8 characters long and combination of uppercase letters, lowercase letters, numbers, special characters.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
