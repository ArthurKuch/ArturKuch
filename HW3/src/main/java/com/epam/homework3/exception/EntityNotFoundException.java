package com.epam.homework3.exception;

import com.epam.homework3.entity.ErrorType;

/**
 * @author Artur Kuch
 */
public class EntityNotFoundException extends ServiceException{

    private static final String DEFAULT_MESSAGE = "Entity isn't found";

    public EntityNotFoundException(){
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType(){
        return ErrorType.VALIDATION_ERROR_TYPE;
    }

}
