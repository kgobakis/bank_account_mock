package com.dkb.bank_account_mock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    @Modifying
    @Query("UPDATE Account a set a.locked = :n WHERE a.IBAN = :IBAN")
    void setAccountLock(@Param("IBAN") String i, @Param("n") int n);

    @Transactional
    @Modifying
    @Query("UPDATE Account a set a.locked = :n WHERE a.IBAN = :IBAN")
    void setAccountUnlock(@Param("IBAN") String i, @Param("n") int n);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Account (id,customerID,iban , type, balance) values (:id,:customerid, :IBAN, :type, :balance)", nativeQuery = true)
    void setAccountAdd(@Param("id") Long id, @Param("customerid") Long customerid, @Param("IBAN") String iban,
            @Param("type") int type, @Param("balance") double balance);

    @Transactional
    @Query("FROM Account a WHERE a.IBAN = :IBAN")
    Account findByIBAN(@Param("IBAN") String i);

    @Transactional
    @Query("FROM Account a WHERE a.customerid = :id")
    List<Account> findListById(@Param("id") Long id);

}
