package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UPITransferService implements TransferService {

    private final AccountRepository accountRepository;

    @Transactional
    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, Double amount) {

        Account fromAccount = accountRepository.findById(fromAccountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account Not found - " + fromAccountNumber));
        Account toAccount = accountRepository.findById(toAccountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account Not found - " + toAccountNumber));
        if (fromAccount.getBalance() < amount) {
            throw new InsufficientFundsException(String.valueOf("No enough funds in account - " + fromAccountNumber));
        }
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

    }

}
