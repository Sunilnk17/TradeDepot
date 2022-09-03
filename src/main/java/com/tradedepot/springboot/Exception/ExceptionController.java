package com.tradedepot.springboot.Exception;

import com.tradedepot.springboot.models.Response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = {Exception.class})
    //TODO: Extend for future scenario error handling.
    public ResponseEntity<Object> handleAnyException(Exception ex) {

        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .type("https://trade-depot.com/#internal-server-error")
                .title("Internal call failure")
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .detail(ex.getMessage()).build();

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
