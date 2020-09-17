package com.dkb.bank_account_mock.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerAccount")
public class CustomerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerAccountId;

    private Long customerId;
    private Long accountId;
}
