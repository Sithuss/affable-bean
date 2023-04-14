package com.example.simpleaff.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CreditCardValidation implements ConstraintValidator<CreditCard, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (!s.matches("^[0-9-]*$")) {
            return false;
        }
        return true;
    }
}
