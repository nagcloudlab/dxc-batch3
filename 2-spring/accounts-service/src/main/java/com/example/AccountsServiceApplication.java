package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import lombok.Data;
import reactor.core.publisher.Mono;

@Data
@Table(name="accounts")
class Account {
	@Id
	private String number;
	private double balance;
}

interface AccountRepository extends R2dbcRepository<Account, String> {
}

@Controller
class AccountController {

	@Autowired
	AccountRepository accountRepository;

	@RequestMapping("/accounts/{number}")
	@ResponseBody
	Mono<Account> getAccount(@PathVariable String number) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		Mono<Account> mono = accountRepository.findById(number);
		return mono.delayElement(java.time.Duration.ofSeconds(1));
	}

}

@EnableR2dbcRepositories
@SpringBootApplication
public class AccountsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsServiceApplication.class, args);
	}

}
