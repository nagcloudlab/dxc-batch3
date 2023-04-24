package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.AccountRepositoryFactory;
import com.example.repository.NoSqlAccountRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;

public class Application {
    public static void main(String[] args) {

        // init / boot
        System.out.println("-".repeat(100));
        AccountRepository jdbcAccountRepository = AccountRepositoryFactory.createAccountRepository("jdbc");
        AccountRepository nosqlAccountRepository = new NoSqlAccountRepository();
        TransferService transferService = new UPITransferService(nosqlAccountRepository);
        System.out.println("-".repeat(100));

        // use
        transferService.transfer(100.00, "1", "2");
        System.out.println("-".repeat(50));
        transferService.transfer(100.00, "2", "1");

        System.out.println("-".repeat(100));
        // destroy
        System.out.println("-".repeat(100));

    }
}
