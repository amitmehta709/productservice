package com.ecom.productservice.advices;

import com.ecom.productservice.dtos.ExceptionDto;
import com.ecom.productservice.exception.AuthencationException;
import com.ecom.productservice.exception.BadRequestException;
import com.ecom.productservice.exception.NotFoundException;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ExceptionDto> handleRuntimeException(RuntimeException ex)
    {
        ExceptionDto exceptionDto = new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        ex.printStackTrace();
        return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException ex)
    {
        return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND,ex.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthencationException.class)
    ResponseEntity<ExceptionDto> handleAuthenticationException(AuthencationException ex)
    {
        return new ResponseEntity<>(new ExceptionDto(HttpStatus.UNAUTHORIZED,ex.getMessage()),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BadRequestException.class)
    ResponseEntity<ExceptionDto> handleBadRequestException(BadRequestException ex)
    {
        return new ResponseEntity<>(new ExceptionDto(HttpStatus.BAD_REQUEST,ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ExceptionDto> handleNumberFormatException() {
        return new ResponseEntity<>(new ExceptionDto(HttpStatus.BAD_REQUEST, "Invalid Format number"),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionDto> handleArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(new ExceptionDto(HttpStatus.BAD_REQUEST, "Invalid Data Type"),
                HttpStatus.BAD_REQUEST);
    }
}
