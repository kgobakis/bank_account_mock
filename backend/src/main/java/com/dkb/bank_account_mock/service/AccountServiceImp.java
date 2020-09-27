package com.dkb.bank_account_mock.service;

import com.dkb.bank_account_mock.models.Account;
import com.dkb.bank_account_mock.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
        this.accountRepository.findByIBAN(IBAN);
        return null;
    }
}
