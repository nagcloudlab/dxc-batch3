package com.example.repository;

import com.example.model.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Component
@Repository
//@Qualifier("secondary")
@AccountRepoQualifier(
        database = "mysql",
        tech = "jpa"
)
public class JpaAccountRepository implements AccountRepository{
    @Override
    public Optional<Account> loadAccount(String number) {
        return Optional.empty();
    }

    @Override
    public int updateAccount(Account account) {
        return 0;
    }
}
