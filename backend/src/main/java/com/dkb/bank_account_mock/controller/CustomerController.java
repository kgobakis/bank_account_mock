package com.dkb.bank_account_mock.controller;

import com.dkb.bank_account_mock.models.CustomerAccount;
import com.dkb.bank_account_mock.repository.AccountRepository;
import com.dkb.bank_account_mock.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/customer/{id}")
    public CustomerAccount getCustomerAccountById(@PathVariable("id") Long id) {
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setCustomer(customerRepository.findById(id).get());
        customerAccount.setAccounts(accountRepository.findListById(customerAccount.getCustomer().getAccountid()));
        return customerAccount;
    }

    @GetMapping("/")
    public String hi() {

        return "Hi!";
    }
}
