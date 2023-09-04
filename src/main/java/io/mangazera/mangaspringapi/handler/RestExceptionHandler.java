package io.mangazera.mangaspringapi.handler;

import io.mangazera.mangaspringapi.exception.badrequest.BadRequestException;
import io.mangazera.mangaspringapi.exception.badrequest.BadRequestExceptionDetails;
import io.mangazera.mangaspringapi.exception.notfound.NotFoundException;
import io.mangazera.mangaspringapi.exception.notfound.NotFoundExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundExceptionDetails> handleObjectNotFoundException(NotFoundException notFoundException) {
        NotFoundExceptionDetails errorDetails = NotFoundExceptionDetails.builder()
                .title("Object not found, check the documentation for more information")
                .status(404)
                .timestamp(LocalDateTime.now())
                .details(notFoundException.getMessage())
                .developerMessage(notFoundException.getClass().getName())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException badRequestException) {
        BadRequestExceptionDetails errorDetails = BadRequestExceptionDetails.builder()
                .title("Bad request, check the documentation for more information")
                .status(400)
                .timestamp(LocalDateTime.now())
                .details(badRequestException.getMessage())
                .developerMessage(badRequestException.getClass().getName())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}
