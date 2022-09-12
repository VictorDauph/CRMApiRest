package com.m2i.crm.service;

import java.util.List;

import com.m2i.crm.model.Customer;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    void create(Customer customer);
    void update(Customer customer, Long id);
    Customer delete(Long id);
}
