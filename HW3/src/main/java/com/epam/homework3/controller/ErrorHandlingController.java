package com.epam.homework3.controller;

import com.epam.homework3.entity.Error;
import com.epam.homework3.entity.ErrorType;
import com.epam.homework3.exception.EntityNotFoundException;
import com.epam.homework3.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Artur Kuch
 */
@Slf4j
@RestControllerAdvice
public class ErrorHandlingController  {

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

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex, HandlerMethod hm) {
        log.error("handleException: message: {}, method: {}", ex.getMessage(),
                hm.getMethod().getName(), ex);
        Error error = new Error(ex.getMessage(), ErrorType.FATAL_ERROR_TYPE, LocalDateTime.now());
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<List<Error>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        log.error("handleMethodArgumentNotValidException: message: {}", ex.getMessage(), ex);
        List<Error> errorList = ex.getBindingResult().getAllErrors()
                .stream()
                .map(x -> new Error(x.getDefaultMessage(), ErrorType.VALIDATION_ERROR_TYPE, LocalDateTime.now())).toList();
       return new ResponseEntity<>(errorList, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
