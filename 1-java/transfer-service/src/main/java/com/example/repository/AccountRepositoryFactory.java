package com.example.repository;

// Factory-class
public class AccountRepositoryFactory {

    // Factory-method
    public static AccountRepository createAccountRepository(String dataAccessTech) {
        if (dataAccessTech.equals("jdbc")) {
            return new JdbcAccountRepository();
        }
        if (dataAccessTech.equals("jpa")) {
            return new JpaAccountRepository();
        }
        return null;
    }

}
