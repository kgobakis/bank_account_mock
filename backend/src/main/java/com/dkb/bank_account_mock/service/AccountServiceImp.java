package com.dkb.bank_account_mock.service;

import com.dkb.bank_account_mock.models.Account;
import com.dkb.bank_account_mock.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class AccountServiceImp implements AccountService{


    @Qualifier("accountRepository")
    private AccountRepository accountRepository;

    public AccountServiceImp ( AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void addMoneyByIBAN(String IBAN, double amount) {
        Account currentAccount = accountRepository.findByIBAN(IBAN);
        if (currentAccount != null)
            accountRepository.setAccountBalance(currentAccount.getId(), currentAccount.getBalance() + amount);
    }

    @Override
    public Account findByIBAN(String IBAN) {
        accountRepository.findByIBAN(IBAN);
        return null;
    }

    @Override
    public void setAccountBalance(Long id, double v) {
        accountRepository.setAccountBalance(id, v);
    }

    @Override
    public List<Account> listAccountsByType() {
        List<Account> allAccounts = accountRepository.findAll();
        Collections.sort(allAccounts, Comparator.comparing(Account::getType));
        return allAccounts;
    }

    @Override
    public void setAccountAdd(Long id, Long customerid, String iban, int type, double balance) {
        accountRepository.setAccountAdd(id, customerid, iban, type, balance);
    }

    @Override
    public void toggleAccountLockedByIBAN(String iban) {
        accountRepository.toggleAccountLockedByIBAN(iban);
    }

    @Override
    public void transferMoney(String fromIBAN, String toIBAN, double amount) {
        Account fromAccount = accountRepository.findByIBAN(fromIBAN);
        Account toAccount = accountRepository.findByIBAN(toIBAN);

        // Checking if account is locked
        if (fromAccount.isLocked() || toAccount.isLocked() ) {
            return;
        }

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
}
