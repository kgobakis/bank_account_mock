package com.dkb.bank_account_mock.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Account")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String IBAN;
    private Long customerid;
    private Long type;
    private String description;
    private double balance;
    private boolean locked;


}
