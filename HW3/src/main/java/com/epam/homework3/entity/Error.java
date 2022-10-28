package com.epam.homework3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Artur Kuch
 */

@AllArgsConstructor
@Data
public class Error {


    private String message;

    private ErrorType errorType;

    private LocalDateTime timeStamp;

}
