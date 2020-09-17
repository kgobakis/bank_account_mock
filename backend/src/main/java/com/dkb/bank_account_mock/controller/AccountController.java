package com.dkb.bank_account_mock.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.dkb.bank_account_mock.models.Account;
import com.dkb.bank_account_mock.models.Transaction;
import com.dkb.bank_account_mock.repository.AccountRepository;
import com.dkb.bank_account_mock.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionRepository transactionRepository;

    /* Deposit money into a specified bank account */
    @PostMapping("/addingmoney/iban")
    public void addingMoneyUsingIban(@RequestParam String IBAN, @RequestParam double amount) {
        Account currentAccount = accountRepository.findByIBAN(IBAN);

        accountRepository.setAccountBalance(currentAccount.getId(), currentAccount.getBalance() + amount);

    }

    /* Transfer some money across two bank accounts */
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

    /* Show current balance of the specific bank account */
    @GetMapping("/account/balance")
    public double getAccountBalance(@RequestParam String IBAN) {
        Account currentAccount = accountRepository.findByIBAN(IBAN);
        return currentAccount.getBalance();
    }

    /* Filter accounts by account type */
    @GetMapping("/accounts/type")
    public List<Account> listAccountByType() {
        List<Account> allAccounts = accountRepository.findAll();
        Collections.sort(allAccounts, Comparator.comparing(Account::getType));
        return allAccounts;
    }

    /* Show a transaction history */
    @GetMapping("/account/transactions")
    public List<Transaction> listAccountTransactions(@RequestParam String IBAN) {
        Account currentAccount = accountRepository.findByIBAN(IBAN);

        return transactionRepository.findListById(currentAccount.getId());
    }
}
