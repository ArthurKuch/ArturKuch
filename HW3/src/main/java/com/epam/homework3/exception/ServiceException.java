package com.epam.homework3.exception;

import com.epam.homework3.entity.ErrorType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Artur Kuch
 */
@Data
@EqualsAndHashCode
public abstract class ServiceException extends RuntimeException {

    private ErrorType errorType;

    public ServiceException(String message){
        super(message);
    }

    public ErrorType getErrorType(){
        return ErrorType.FATAL_ERROR_TYPE;
    }

}
