package com.example.demo.controller.advice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.controller.DTO.response.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class RestExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse handleInternalErrorServer(final Exception exception, final HttpServletRequest request){
        return new ErrorResponse(
            LocalDateTime.now(),
            request.getServletPath(),
            INTERNAL_SERVER_ERROR.value(),
            INTERNAL_SERVER_ERROR.getReasonPhrase(),
            exception.getMessage()
        );
    }
}
