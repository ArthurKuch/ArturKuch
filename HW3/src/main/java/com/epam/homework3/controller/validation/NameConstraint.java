package com.epam.homework3.controller.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @author Artur Kuch
 */
@Documented
@Constraint(validatedBy = NameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NameConstraint {
    String message() default "Invalid mame";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
