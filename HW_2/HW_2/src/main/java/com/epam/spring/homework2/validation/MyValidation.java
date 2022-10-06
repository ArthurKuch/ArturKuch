package com.epam.spring.homework2.validation;

import com.epam.spring.homework2.exceptions.ValidationException;

/**
 * @author Artur Kuch
 */
@FunctionalInterface
public interface MyValidation {
    void validate() throws ValidationException;
}
