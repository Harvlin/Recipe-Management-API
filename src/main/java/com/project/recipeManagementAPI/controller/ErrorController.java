package com.project.recipeManagementAPI.controller;

import com.project.recipeManagementAPI.domain.ApiErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@Slf4j
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {
        log.error("Caught exception ", ex);
        ApiErrorResponse error = ApiErrorResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("An unexpected error occurred\n" + ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> handlerIllegalArgumentException(IllegalArgumentException ex) {
        ApiErrorResponse error = ApiErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handlerEntityNotFoundException(EntityNotFoundException ex) {
        ApiErrorResponse error = ApiErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
