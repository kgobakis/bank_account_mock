package com.dkb.bank_account_mock.service;

import com.dkb.bank_account_mock.models.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findTransactionByIBAN(String iban);
}
