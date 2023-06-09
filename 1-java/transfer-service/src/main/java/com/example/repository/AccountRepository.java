package com.example.repository;

import com.example.entity.Account;

public interface AccountRepository {
    public Account loadAccount(String number);
    public void updateAccount(Account account);
}
