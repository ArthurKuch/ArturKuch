package com.epam.spring.homework2.exceptions;

/**
 * @author Artur Kuch
 */
public class ValidationException extends Exception{
    public ValidationException(String message) {
        super(message);
    }

}
