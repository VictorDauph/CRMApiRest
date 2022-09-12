package com.m2i.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.m2i.crm.model.Customer;
import com.m2i.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;
    
     @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void create(Customer customer) {

        customerRepository.save(customer);
    }

    @Override
    public Customer delete(Long id) {
        Customer oldCustomer = customerRepository.findById(id).orElse(null);
        customerRepository.deleteById(id);
        return oldCustomer;
    }

    @Override
    public List<Customer> findAll() {

        // TODO Auto-generated method stub
        return customerRepository.findAll();

    }

    @Override
    public Customer findById(Long id) {

        // TODO Auto-generated method stub
        return customerRepository.findById(id).orElse(null) ;

    }

    @Override
    public void update(Customer customer, Long id) {
        // TODO Auto-generated method stub
        Customer oldCustomer = customerRepository.findById(id).orElse(null);

        oldCustomer.copy(customer);
        customerRepository.save(oldCustomer);

    }

    
}
