package com.example.simpleaff.validation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OnlyNumbersValidation implements ConstraintValidator<OnlyNumbers, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
//        char[] str = s.toCharArray();
//        for (char c : str) {
//            if (Character.isDigit(c)) {
//                return false;
//            }
//        }

        //using regular expression
        if (s.matches(".*[A-z].*")) {
            return false;
        }
        return true;
    }
}
