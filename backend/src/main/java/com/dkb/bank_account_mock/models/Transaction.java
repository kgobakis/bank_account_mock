package com.dkb.bank_account_mock.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Transaction")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "accountid")
    private Long accountid;
    @Column(name = "timestamp")
    private Date timestamp;
    @Column(name = "amount")
    private double amount;
    @Column(name = "description")
    private String description;
}
