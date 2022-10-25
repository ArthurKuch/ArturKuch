package com.epam.homework3.controller.validation;

//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Artur Kuch
 */
public class NameValidator implements
        ConstraintValidator<NameConstraint, String> {

    @Override
    public void initialize(NameConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && s.matches("[A-Z][a-z]*");
    }
}
