package ru.tripadvisor.tripsocial.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> catchResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(new TripSocialError(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> catchInvalidInputDataException(InvalidInputDataException e) {
        return new ResponseEntity<>(new TripSocialError(e.getMessages()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<?> catchExecuteOperationException(ExecuteOperationException e) {
        return new ResponseEntity<>(new TripSocialError(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
