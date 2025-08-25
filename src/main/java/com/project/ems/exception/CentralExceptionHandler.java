package com.project.ems.exception;


import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class CentralExceptionHandler {
    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ErrorInfo> handleEmployeeException(EmployeeException ex) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setTimeStamp(LocalDateTime.now());
        errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorInfo.setErrorMessage(ex.getMessage());
        log.error("EmployeeException occurred: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorInfo> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setTimeStamp(LocalDateTime.now());
        errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));
        errorInfo.setErrorMessage(errorMessage);
        log.error("MethodArgumentNotValidException occurred: {}", errorMessage, ex);
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorInfo> handleConstraintViolationException(ConstraintViolationException ex) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setTimeStamp(LocalDateTime.now());
        errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
        String errorMessage = ex.getConstraintViolations().stream()
                .map(jakarta.validation.ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
        errorInfo.setErrorMessage(errorMessage);
        log.error("ConstraintViolationException occurred: {}", errorMessage, ex);
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
}