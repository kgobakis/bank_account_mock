package com.dkb.bank_account_mock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import com.dkb.bank_account_mock.models.Account;

@EnableJpaRepositories
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Account a set a.balance = :balance WHERE a.id = :id")
    void setAccountBalance(@Param("id") Long id, @Param("balance") double balance);

    @Transactional
    @Query("FROM Account a WHERE a.IBAN = :IBAN")
    Account findByIBAN(@Param("IBAN") String i);

    @Transactional
    @Query("FROM Account a WHERE a.id = :id")
    Account findById(@Param("id") String id);
}
