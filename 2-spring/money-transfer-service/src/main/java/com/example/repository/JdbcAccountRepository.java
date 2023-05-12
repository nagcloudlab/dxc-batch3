package com.example.repository;

import com.example.model.Account;
import com.example.service.UPITransferService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class JdbcAccountRepository implements AccountRepository{

    private static Logger logger = Logger.getLogger(AccountRepository.class);

//    @Autowired
    private DataSource dataSource;

//     @Autowired
    public JdbcAccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        logger.info("JdbcAccountRepository created");
    }


//    @Autowired(required = false)
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Override
    public Optional<Account> loadAccount(String number) {
        logger.info("loadAccount - "+number);

        Connection connection=null;
        try {
            connection= dataSource.getConnection();
            logger.info("connection created");
            //...
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(number.equals("13"))
            return  Optional.empty();
        return Optional.of(new Account(number, 1000.00));
    }

    @Override
    public Account updateAccount(Account account) {
        logger.info("updateAccount - "+account);
        //...
        return account;
    }
}
