package com.dkb.bank_account_mock.controller;

import com.dkb.bank_account_mock.models.Account;
import com.dkb.bank_account_mock.models.Transaction;
import com.dkb.bank_account_mock.service.AccountServiceImp;
import com.dkb.bank_account_mock.service.TransactionServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class AccountController {


    AccountServiceImp accountServiceImp;
    TransactionServiceImp transactionServiceImp;

    public AccountController(AccountServiceImp accountServiceImp, TransactionServiceImp transactionServiceImp) {

        this.accountServiceImp = accountServiceImp;
        this.transactionServiceImp = transactionServiceImp;
    }

    /* Deposit money into a specified bank account */
    @PatchMapping("/add-money/iban")
    public void addingMoneyUsingIban(@RequestParam String IBAN, @RequestParam double amount) {
        accountServiceImp.addMoneyByIBAN(IBAN, amount);
    }

    /* Transfer some money across two bank accounts */
    @PostMapping("/transfer-money/iban")
    public void transferMoney(@RequestBody String fromIBAN, @RequestBody String toIBAN, @RequestBody double amount) {
        accountServiceImp.transferMoney(fromIBAN, toIBAN, amount);
    }

    /* Show current balance of the specific bank account */
    @GetMapping("/account/balance")
    public double getAccountBalance(@RequestBody String IBAN) {
        Account currentAccount = accountServiceImp.findByIBAN(IBAN);
        return currentAccount.getBalance();
    }

    /* Filter accounts by account type */
    @GetMapping("/accounts/type")
    public List<Account> listAccountByType() {
        return accountServiceImp.listAccountsByType();
    }

    /*
     * Show a transaction history: For an account, specified by IBAN, show the
     * transaction history
     */
    @GetMapping("/account/transactions")
    public List<Transaction> listAccountTransactions(@RequestParam String IBAN) {
        return transactionServiceImp.findTransactionByIBAN(IBAN);
    }

    /*
     * Bonus * open account
     */
    @PostMapping("/account/add")
    public void openAccount(@RequestParam("id") Long id, @RequestParam("customerid") Long customerid,
                            @RequestParam("IBAN") String iban, @RequestParam("type") int type, @RequestParam("balance") double balance) {
        accountServiceImp.setAccountAdd(id, customerid, iban, type, balance);
    }

    /*
     * Bonus * account locking/unlocking
     */
    @PatchMapping("/account/lock")
    public void accountLock(@RequestParam String IBAN) {
        accountServiceImp.toggleAccountLockedByIBAN(IBAN);
    }



}
