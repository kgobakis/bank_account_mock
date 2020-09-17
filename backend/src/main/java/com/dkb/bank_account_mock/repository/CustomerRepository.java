package com.dkb.bank_account_mock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.dkb.bank_account_mock.models.Customer;

@EnableJpaRepositories
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
