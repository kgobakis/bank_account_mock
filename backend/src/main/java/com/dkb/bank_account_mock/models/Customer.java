package com.dkb.bank_account_mock.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Long accountid;
    private String email;

}
