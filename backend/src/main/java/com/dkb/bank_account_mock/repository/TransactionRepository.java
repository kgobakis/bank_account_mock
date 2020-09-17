package com.dkb.bank_account_mock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

import com.dkb.bank_account_mock.models.Transaction;

@EnableJpaRepositories
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Transactional
    @Query("FROM Transaction t WHERE t.accountid = :id")
    List<Transaction> findListById(@Param("id") Long id);
}
