package com.dkb.bank_account_mock.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dkb.bank_account_mock.models.Customer;
import com.dkb.bank_account_mock.repository.AccountRepository;
import com.dkb.bank_account_mock.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomerById(@PathVariable("id") Long id) {

        return customerRepository.findById(id);
    }

    @GetMapping("/")
    public String hi() {

        return "Hi!";
    }
}
