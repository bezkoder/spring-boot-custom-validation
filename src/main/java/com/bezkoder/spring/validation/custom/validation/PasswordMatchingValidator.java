package com.bezkoder.spring.validation.custom.validation;

import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchingValidator implements ConstraintValidator<PasswordMatching, Object> {

  private String password;
  private String confirmPassword;

  @Override
  public void initialize(PasswordMatching matching) {
    this.password = matching.password();
    this.confirmPassword = matching.confirmPassword();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
    Object passwordValue = new BeanWrapperImpl(value).getPropertyValue(password);
    Object confirmPasswordValue = new BeanWrapperImpl(value).getPropertyValue(confirmPassword);

    return (passwordValue != null) ? passwordValue.equals(confirmPasswordValue) : confirmPasswordValue == null;
  }
}