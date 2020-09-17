package com.dkb.bank_account_mock.models;

import java.util.List;

public class CustomerAccount {
    private Customer customer;
    private List<Account> accounts;

    public CustomerAccount() {
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}
