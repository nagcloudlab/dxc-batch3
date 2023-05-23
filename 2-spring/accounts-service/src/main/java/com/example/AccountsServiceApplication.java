package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
class Account {
	@Id
	private String number;
	private double balance;
}

interface AccountRepository extends JpaRepository<Account, String> {
}

@Controller
class AccountController {

	@Autowired
	AccountRepository accountRepository;

	@RequestMapping("/accounts/{number}")
	@ResponseBody
	Account getAccount(@PathVariable String number) {
		System.out.println(Thread.currentThread().getName());
		Account account = accountRepository.findById(number).orElse(null); // IO
		return account;
	}

}

@SpringBootApplication
public class AccountsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsServiceApplication.class, args);
	}

}
