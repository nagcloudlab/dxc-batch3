package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.example.service.TransferService;

@SpringBootApplication
public class MoneyTransferSystemApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MoneyTransferSystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TransferService transferService) {
		return args -> {
			// transferService.transfer("1", "2", 100.00);
		};
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MoneyTransferSystemApplication.class);
	}

}
