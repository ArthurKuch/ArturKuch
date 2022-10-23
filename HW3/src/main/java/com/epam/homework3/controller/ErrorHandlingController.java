package com.epam.homework3.controller;

import com.epam.homework3.entity.Error;
import com.epam.homework3.exception.EntityNotFoundException;
import com.epam.homework3.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Kuch
 */
@Slf4j
@RestControllerAdvice
public class ErrorHandlingController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<Error> handleEntityNotFoundException(EntityNotFoundException ex, HandlerMethod hm){
        log.error("handleEntityNotFoundException: message:{}, method{} ", ex.getMessage(),
                hm.getMethod().getName(), ex);
        Error error = new Error(ex.getMessage(), ex.getErrorType(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ServiceException.class)
    public final ResponseEntity<Error> handleServiceException(ServiceException ex, HandlerMethod hm){
        log.error("handlerServiceException: message: {}, method: {}", ex.getMessage(),
                hm.getMethod().getName(), ex);
        Error error = new Error(ex.getMessage(), ex.getErrorType(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
