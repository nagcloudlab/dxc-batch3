package com.example;

import com.example.service.AccountNotFoundException;
import com.example.service.TransferService;
import org.example.dxc.DxcAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication(
        scanBasePackages = "com.example"
)
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class Application {
    public static void main(String[] args) {


        //--------------------------------------------------------------------------
        // init / boot
        //--------------------------------------------------------------------------
        System.out.println("-".repeat(100));

        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(Application.class, args);

        System.out.println("-".repeat(100));
        //--------------------------------------------------------------------------
        // use
        //--------------------------------------------------------------------------

        TransferService transferService1=applicationContext.getBean("upiTransferService", TransferService.class);
        System.out.println(transferService1.getClass());
        try {
            transferService1.transfer(1000.00, "2", "1");
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
