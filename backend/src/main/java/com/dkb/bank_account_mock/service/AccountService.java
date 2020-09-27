package com.dkb.bank_account_mock.service;

import com.dkb.bank_account_mock.models.Account;

public interface AccountService {

    Account findByIBAN(String IBAN);
    public void addMoneyByIBAN(String IBAN, double amount);

}
