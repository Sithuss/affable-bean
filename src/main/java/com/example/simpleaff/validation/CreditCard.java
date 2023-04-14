package com.example.simpleaff.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CreditCardValidation.class)
public @interface CreditCard {

    String message();

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default {};
}
