package com.dkb.bank_account_mock.repository;

import com.dkb.bank_account_mock.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@EnableJpaRepositories

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Account a set a.balance = :balance WHERE a.id = :id")
    void setAccountBalance(@Param("id") Long id, @Param("balance") double balance);

    @Transactional
    @Modifying
    @Query("UPDATE Account a set a.locked = CASE a.locked WHEN TRUE THEN FALSE\n" +
            "    ELSE TRUE END WHERE a.IBAN = :IBAN")
    void toggleAccountLockedByIBAN(@Param("IBAN") String IBAN);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Account (id,customerID,iban , type, balance) values (:id,:customerid, :IBAN, :type, :balance)", nativeQuery = true)
    void setAccountAdd(@Param("id") Long id, @Param("customerid") Long customerid, @Param("IBAN") String iban,
                       @Param("type") int type, @Param("balance") double balance);

    Account findByIBAN(@Param("IBAN") String i);

}
