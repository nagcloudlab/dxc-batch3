package com.example.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

//@Component
@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = {
        "com.example.aspect",
        "com.example.service",
        "com.example.repository"
})
@PropertySource("classpath:application.properties")
public class MoneyTransferServiceConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    @Scope("singleton")
    @Lazy(value = false)
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("dataSource.driverClassName"));
        dataSource.setUrl(environment.getProperty("dataSource.url"));
        dataSource.setUsername(environment.getProperty("dataSource.username"));
        dataSource.setPassword(environment.getProperty("dataSource.password"));
        return dataSource;
    }

}
