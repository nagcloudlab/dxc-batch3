package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("upiTransferService")
public class UPITransferService implements TransferService {

    private static Logger logger = Logger.getLogger(UPITransferService.class);
    private AccountRepository accountRepository;

//    @Autowired
    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("UPITransferService created");
    }

    @Override
    public boolean transfer(double amount, String source, String destination) {
        //System.out.println("Transferring " + amount + " from " + source + " to "); // current thread
        logger.info("Transferring " + amount + " from " + source + " to "); // different thread
        Account sourceAccount = accountRepository.loadAccount(source)
                .orElseThrow(() -> new AccountNotFoundException(source));
        Account destinationAccount = accountRepository.loadAccount(destination)
                .orElseThrow(()->new AccountNotFoundException(destination));

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);

        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(destinationAccount);
        logger.info("Transferred " + amount + " from " + source + " to " + destination);
        return false;
    }
}
