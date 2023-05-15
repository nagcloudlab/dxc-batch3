package com.example;

import com.example.config.DataSourceConfiguration;
import com.example.config.JdbcConfiguration;
import com.example.service.AccountNotFoundException;
import com.example.service.TransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;



@Configuration
@Import({
        DataSourceConfiguration.class,
        JdbcConfiguration.class
})
@ComponentScan
@EnableAspectJAutoProxy
public class Application {
    public static void main(String[] args) {

        //--------------------------------------------------------------------------
        // init / boot
        //--------------------------------------------------------------------------
        System.out.println("-".repeat(100));

        // spring component management
        ConfigurableApplicationContext applicationContext=
               // new ClassPathXmlApplicationContext("money-transfer-service.xml");
                new AnnotationConfigApplicationContext(Application.class);

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
