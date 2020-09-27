package com.dkb.bank_account_mock.service;


import com.dkb.bank_account_mock.models.Account;
import com.dkb.bank_account_mock.models.Transaction;
import com.dkb.bank_account_mock.repository.AccountRepository;
import com.dkb.bank_account_mock.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImp implements TransactionService {

    @Qualifier("transactionRepository")
    TransactionRepository transactionRepository;
    @Qualifier("accountRepository")
    AccountRepository accountRepository;


    public TransactionServiceImp(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Transaction> findTransactionByIBAN(String iban) {
        Account currentAccount = accountRepository.findByIBAN(iban);
        return transactionRepository.findListById(currentAccount.getId());
    }
}
