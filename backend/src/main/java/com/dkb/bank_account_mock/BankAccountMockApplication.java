package com.dkb.bank_account_mock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.dkb")

@SpringBootApplication
public class BankAccountMockApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountMockApplication.class, args);
	}

}
