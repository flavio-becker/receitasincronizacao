package com.SincronizacaoReceita.SincronizacaoReceita.handler;

import com.SincronizacaoReceita.SincronizacaoReceita.exception.ErrorDetails;
import com.SincronizacaoReceita.SincronizacaoReceita.exception.ReceitaBadRequestDetails;
import com.SincronizacaoReceita.SincronizacaoReceita.exception.ReceitaSincronizacaoException;
import com.opencsv.exceptions.CsvException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CsvException.class)
    protected ResponseEntity<Object> handleExceptionInternal(CsvException ex,
                                                             HttpHeaders headers,
                                                             HttpStatus status) {

        ErrorDetails errorDetails = ErrorDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(status.value())
                .title("Internal Exception")
                .detail(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .build();

        return new ResponseEntity<>(errorDetails, headers, status);
    }

    @ExceptionHandler(ReceitaSincronizacaoException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ReceitaSincronizacaoException exception,
                                                              HttpServletRequest request) {
        ReceitaBadRequestDetails receitaDetails = ReceitaBadRequestDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Resource not found")
                .detail(exception.getMessage())
                .path(request.getRequestURI())
                .developerMessage(exception.getClass().getName())
                .build();

        return new ResponseEntity<>(receitaDetails, HttpStatus.BAD_REQUEST);
    }
}