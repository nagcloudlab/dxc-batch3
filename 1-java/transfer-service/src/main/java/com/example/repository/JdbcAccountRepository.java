package com.example.repository;

import com.example.entity.Account;
import org.apache.log4j.Logger;

public class JdbcAccountRepository implements AccountRepository {

    private static Logger logger=Logger.getLogger("transfer-service");

    public JdbcAccountRepository() {
        logger.info("JdbcAccountRepository component instance created");
    }

    public Account loadAccount(String number){
        logger.info("loadAccount-"+number);
        // db code
        return new Account(number,1000.00);
    }

    public void updateAccount(Account account){
        logger.info("updateAccount-"+account.getNumber());
        // db code
    }


}
