package com.example.service;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String source) {
        super(source);
    }
}
