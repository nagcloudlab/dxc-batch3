package com.example.repository;

import com.example.entity.Account;

import java.util.Optional;

public interface AccountRepository {
    Optional<Account> loadAccount(String number);
    int updateAccount(Account account);
}
