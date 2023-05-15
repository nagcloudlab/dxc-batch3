package com.example.repository;

import com.example.model.Account;
import com.example.service.UPITransferService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

//@Component
@Repository
//@Qualifier("primary")
@AccountRepoQualifier(
        database = "mysql",
        tech = "jdbc"
)
public class JdbcAccountRepository implements AccountRepository {

    private static Logger logger = Logger.getLogger(AccountRepository.class);

    private JdbcTemplate jdbcTemplate;

    //     @Autowired
    public JdbcAccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        logger.info("JdbcAccountRepository created");
    }

    @Override
    public Optional<Account> loadAccount(String number) {
        logger.info("loadAccount - " + number);
        Account account = jdbcTemplate.queryForObject("SELECT * FROM accounts WHERE number =?", (rs, index) -> {
            return new Account(rs.getString("number"), rs.getDouble("balance"));
        }, number);
        if (account == null) {
            return Optional.empty();
        } else {
            return Optional.of(account);
        }
    }

    @Override
    public int updateAccount(Account account) {
        logger.info("updateAccount - " + account);
        return jdbcTemplate.update("UPDATE accounts SET balance =? WHERE number =?", account.getBalance(), account.getNumber());
    }
}
