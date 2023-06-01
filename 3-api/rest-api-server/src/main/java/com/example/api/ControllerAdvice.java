package com.example.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(value = {
            NotFoundException.class
    })
    public ResponseEntity<?> handleException(Throwable e, HttpServletRequest request) {
        HttpError httpError = new HttpError();
        if (e instanceof NotFoundException) {
            httpError.setStatus(404);
        }
        httpError.setMessage(e.getMessage());
        httpError.setTimestamp(LocalDateTime.now().toString());
        httpError.setPath(request.getRequestURI());
        return ResponseEntity.status(httpError.getStatus()).body(httpError);
    }

}
