package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("upiTransferService")
public class UPITransferService implements TransferService {

    private static Logger logger = LoggerFactory.getLogger(UPITransferService.class);
    private AccountRepository accountRepository;


    // 1. command line arguments
    // 2. environment variables
    @Value("${transfer.limit: 1000.00}")
    double transferLimit;


//    @Autowired
    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("UPITransferService created");
    }

    @Override
    @Transactional
    public boolean transfer(double amount, String source, String destination) {
        logger.info("Transferring " + amount + " from " + source + " to "); // different thread
        logger.info("transferLimit: " + transferLimit);
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
