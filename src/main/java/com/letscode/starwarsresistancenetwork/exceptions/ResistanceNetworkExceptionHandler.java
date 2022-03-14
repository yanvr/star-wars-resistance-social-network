package com.letscode.starwarsresistancenetwork.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResistanceNetworkExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handlerBusinessException(BusinessException exception, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        ResistanceNetworkHttpError error = new ResistanceNetworkHttpError(exception.getMessage(), status.name(), status.value());

        return handleExceptionInternal(exception, error, new HttpHeaders(), status, request);
    }
}
