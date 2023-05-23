package com.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Account;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.AccountRepository;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class MoneyTransferSystemApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MoneyTransferSystemApplication.class, args);
	}

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final AccountRepository accountRepository;

	@EventListener(ApplicationStartedEvent.class)
	public void dbInit() {
		System.out.println("dbInit");
		Role memberRole = roleRepository.save(new Role("ROLE_MEMBER"));
		Role adminRole = roleRepository.save(new Role("ROLE_ADMIN"));
		userRepository.save(new User("Nag@example.com", "password", "Nag", List.of(memberRole, adminRole)));
		userRepository.save(new User("Foo@example.com", "password", "Foo", List.of(memberRole)));
		accountRepository.save(new Account("1", 1000.00));
		accountRepository.save(new Account("2", 1000.00));
	}

}
