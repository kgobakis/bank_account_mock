package com.dkb.bank_account_mock.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.dkb.bank_account_mock.models.Account;
import com.dkb.bank_account_mock.models.AccountType;
import com.dkb.bank_account_mock.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/addingmoney/iban")
    public void addingMoneyUsingIban(@RequestParam String IBAN, @RequestParam double amount) {
        Account currentAccount = accountRepository.findByIBAN(IBAN);

        if (currentAccount.getBalance() - amount > 0)
            accountRepository.setAccountBalance(currentAccount.getId(), currentAccount.getBalance() + amount);

    }

    @PostMapping("/addingmoney/id")
    public void addingMoneyUsingId(@RequestParam String id, @RequestParam double amount) {
        Account currentAccount = accountRepository.findById(id);

        if (currentAccount.getBalance() - amount > 0)
            accountRepository.setAccountBalance(currentAccount.getId(), currentAccount.getBalance() + amount);

    }

    @GetMapping("/account/balance")
    public double getAccountBalance(@RequestParam String IBAN) {
        Account currentAccount = accountRepository.findByIBAN(IBAN);
        return currentAccount.getBalance();
    }

    @PostMapping("/transfermoney")
    public void transferMoney(@RequestParam Long fromid, @RequestParam Long toid) {
        Account fromAccount = accountRepository.findById(fromid).orElseThrow();
        Account toAccount = accountRepository.findById(toid).orElseThrow();

        // AccountType fromType =
        // accountTypeRepository.findById(fromAccount.getType()).orElseThrow();
        // AccountType toType =
        // accountTypeRepository.findById(fromAccount.getType()).orElseThrow();
        // // If it is a checking account
        // if (fromType == AccountType.CHECKING) {

        // } else if (fromType == AccountType.SAVINGS) {

        // } else {

        // }

    }

    @GetMapping("/accounts/type")
    public List<Account> listAccountByType() {
        List<Account> allAccounts = accountRepository.findAll();
        Collections.sort(allAccounts, Comparator.comparing(Account::getType));
        return allAccounts;
    }

}
