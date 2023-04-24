package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.repository.AccountRepositoryFactory;
import org.apache.log4j.Logger;

/*

    design & performance issues

    - tight-coupling b/w dependent & dependency objects
        => can't extend with new feature easily
    - unit-testing not possible
        => dev & bug fix slow
    - too many duplicate dependency objects
        => slow , resource usage high


    why these issues ?

    => managing dependency objects by dependent

    solution:

    => don't create dependency in dependent's home ( class ), get from factory  ( factory design pattern )

    limitation on factory design pattern

    - Factory location tight-coupling & performance issue still exist

    best solution:

    => don't create dependency in dependent's home (class ), don't get from factory
       inject by 'third-party'  ( Dependency Inversion Principle / Inversion of Control )

       how to implement IOC ?
       => By  dependency injection ( DI )

       how to implement DI?

       many ways

       -> constructor  ( required dependency )
       -> method       ( optional dependency )

 */

public class UPITransferService implements TransferService {

    private static Logger logger = Logger.getLogger("transfer-service");

    private AccountRepository accountRepository;

    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("UPITransferService component instance created");
    }

    @Override
    public void transfer(double amount, String from, String to) {
        logger.info("transfer initiated");
        //JdbcAccountRepository accountRepository = new JdbcAccountRepository();
        //AccountRepository accountRepository = AccountRepositoryFactory.createAccountRepository("jdbc");
        Account fromAccount = accountRepository.loadAccount(from);
        Account toAccount = accountRepository.loadAccount(to);
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountRepository.updateAccount(fromAccount);
        accountRepository.updateAccount(toAccount);
        logger.info("transfer completed");
    }

}
