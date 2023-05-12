package com.example;

import com.example.config.MoneyTransferServiceConfiguration;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.AccountNotFoundException;
import com.example.service.TransferService;
import com.example.service.UPITransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {


        //--------------------------------------------------------------------------
        // init / boot
        //--------------------------------------------------------------------------
        System.out.println("-".repeat(100));

        // manual component management
        //AccountRepository accountRepository=new JdbcAccountRepository(); // dependency
        //TransferService transferService = new UPITransferService(accountRepository); // dependent

        // spring component management
        ConfigurableApplicationContext applicationContext=
               // new ClassPathXmlApplicationContext("money-transfer-service.xml");
                new AnnotationConfigApplicationContext(MoneyTransferServiceConfiguration.class);


        System.out.println("-".repeat(100));
        //--------------------------------------------------------------------------
        // use
        //--------------------------------------------------------------------------

        TransferService transferService=applicationContext.getBean("upiTransferService", TransferService.class);

        try {
            transferService.transfer(10, "1", "2");
        }catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        //--------------------------------------------------------------------------
        // destroy
        //--------------------------------------------------------------------------
        System.out.println("-".repeat(100));
        System.out.println();
        System.out.println("-".repeat(100));

    }
}
