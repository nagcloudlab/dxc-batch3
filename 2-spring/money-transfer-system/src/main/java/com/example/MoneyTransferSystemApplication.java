package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.service.TransferService;

@SpringBootApplication
public class MoneyTransferSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneyTransferSystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TransferService transferService) {
		return args -> {
			// transferService.transfer("1", "2", 100.00);
		};
	}

}
