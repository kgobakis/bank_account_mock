package com.dkb.bank_account_mock.models;

import lombok.Data;
import org.hibernate.annotations.Type;

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

    @Type(type = "numeric_boolean")
    private boolean locked;


}
