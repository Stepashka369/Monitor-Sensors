package com.task.monitorsensors.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final String ELEMENT_ALREADY_EXISTS = "Such element already exists.";
    private final String ELEMENT_NOT_FOUND = "Element not found.";
    private final String VALIDATION_EXCEPTION = "Element is not valid.";

    @ExceptionHandler(ElementAlreadyExistsException.class)
    public ResponseEntity<String> onElementAlreadyExistsException(ElementAlreadyExistsException exception) {
        return new ResponseEntity<>(ELEMENT_ALREADY_EXISTS, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<String> onElementNotFoundException(ElementNotFoundException exception) {
        return new ResponseEntity<>(ELEMENT_NOT_FOUND, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> onMethodArgumentNotValidException(ConstraintViolationException exception) {
        return new ResponseEntity<>(VALIDATION_EXCEPTION, HttpStatus.BAD_REQUEST);
    }
}
