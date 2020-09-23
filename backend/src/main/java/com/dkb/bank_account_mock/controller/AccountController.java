package com.dkb.bank_account_mock.controller;

import com.dkb.bank_account_mock.models.Account;
import com.dkb.bank_account_mock.models.Transaction;
import com.dkb.bank_account_mock.repository.AccountRepository;
import com.dkb.bank_account_mock.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class AccountController {

    AccountRepository accountRepository;
    TransactionRepository transactionRepository;

    public AccountController(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    /* Deposit money into a specified bank account */
    @PostMapping("/add-money/iban")
    public void addingMoneyUsingIban(@RequestBody String IBAN, @RequestBody double amount) {
        Account currentAccount = accountRepository.findByIBAN(IBAN);
        if (currentAccount != null)
            accountRepository.setAccountBalance(currentAccount.getId(), currentAccount.getBalance() + amount);

    }

    /* Transfer some money across two bank accounts */
    @PostMapping("/transfer-money/iban")
    public void transferMoney(@RequestBody String fromIBAN, @RequestBody String toIBAN, @RequestBody double amount) {
        Account fromAccount = accountRepository.findByIBAN(fromIBAN);
        Account toAccount = accountRepository.findByIBAN(toIBAN);

        // Checking if account is locked
//        if (fromAccount.isLocked() || toAccount.isLocked() ) {
//            return;
//        }

        // If it is a checking account
        if (fromAccount.getType() == 0) {
            accountRepository.setAccountBalance(fromAccount.getId(), fromAccount.getBalance() - amount);
            accountRepository.setAccountBalance(toAccount.getId(), toAccount.getBalance() + amount);
        }
        // If it is a savings account
        else if (fromAccount.getType() == 1) {
            // Only transfer if receiving account is checking
            if (toAccount.getType() == 0) {
                accountRepository.setAccountBalance(fromAccount.getId(), fromAccount.getBalance() - amount);
                accountRepository.setAccountBalance(toAccount.getId(), toAccount.getBalance() + amount);
            }
        }
        // If it is a private account then transfer is not possible, private loan
        // account only allow for purchases
        else {

        }

    }

    /* Show current balance of the specific bank account */
    @GetMapping("/account/balance")
    public double getAccountBalance(@RequestBody String IBAN) {
        System.out.println("YOYO----> " + IBAN);
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

    /*
     * Show a transaction history: For an account, specified by IBAN, show the
     * transaction history
     */
    @GetMapping("/account/transactions")
    public List<Transaction> listAccountTransactions(@RequestParam String IBAN) {
        Account currentAccount = accountRepository.findByIBAN(IBAN);

        return transactionRepository.findListById(currentAccount.getId());
    }

    /*
     * Bonus * open account
     */
    @PostMapping("/account/add")
    public void openAccount(@RequestParam("id") Long id, @RequestParam("customerid") Long customerid,
                            @RequestParam("IBAN") String iban, @RequestParam("type") int type, @RequestParam("balance") double balance) {
        accountRepository.setAccountAdd(id, customerid, iban, type, balance);
    }

    /*
     * Bonus * account locking
     */
    @PostMapping("/account/lock")
    public void accountLock(@RequestParam String IBAN) {
        accountRepository.setAccountLock(IBAN, 1);
    }

    /*
     * Bonus * account locking
     */
    @PostMapping("/account/unlock")
    public void accountUnlock(@RequestParam String IBAN) {
        accountRepository.setAccountUnlock(IBAN, 0);

    }

}
