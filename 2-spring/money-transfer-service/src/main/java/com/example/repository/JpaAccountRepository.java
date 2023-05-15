package com.example.repository;

import com.example.entity.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class JpaAccountRepository implements AccountRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<Account> loadAccount(String number) {
        Account account= entityManager.find(Account.class, number);
        return Optional.ofNullable(account);
    }

    @Override
    public int updateAccount(Account account) {
        account=entityManager.merge(account);
        if(account!=null)
            return 1;
        else return 0;
    }
}
