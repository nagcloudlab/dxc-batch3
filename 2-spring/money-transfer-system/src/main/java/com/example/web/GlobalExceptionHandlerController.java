package com.example.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.AccountNotFoundException;
import com.example.service.InsufficientFundsException;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler({
            AccountNotFoundException.class,
            InsufficientFundsException.class
    })
    public ModelAndView handleException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("exception");
        return modelAndView;
    }

}
