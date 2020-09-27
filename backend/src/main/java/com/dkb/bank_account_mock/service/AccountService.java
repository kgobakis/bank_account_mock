package com.dkb.bank_account_mock.service;

import com.dkb.bank_account_mock.models.Account;

import java.util.List;

public interface AccountService {

    Account findByIBAN(String IBAN);
    public void addMoneyByIBAN(String IBAN, double amount);

    void setAccountBalance(Long id, double v);

    List<Account> listAccountsByType();

    void setAccountAdd(Long id, Long customerid, String iban, int type, double balance);

    void toggleAccountLockedByIBAN(String iban);

    void transferMoney(String fromIBAN, String toIBAN, double amount);
}
