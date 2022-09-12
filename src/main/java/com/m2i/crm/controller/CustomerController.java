package com.m2i.crm.controller;

import com.m2i.crm.model.Customer;
import com.m2i.crm.service.CustomerService;
import com.m2i.crm.service.ICustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200") //CrossOrigin permet de gérer les problèmes de Cors, l'URL indiquée est celle du front
@RequestMapping("/customers")
public class CustomerController {
    

    private ICustomerService customerService ;
    private Customer customerToDelete; 
    
    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    
    // listAll [GET] -> customers/
    @GetMapping
    @ApiOperation(value="get all customers", response=Customer.class )
    public ResponseEntity<Object> getProducts(){
        return new ResponseEntity<>( customerService.findAll() ,HttpStatus.OK);
    }
    
    // getById [GET] -> customers/{id}
    @GetMapping(value="/{id}")
    @ApiOperation(value="get one customer by ID", response= Customer.class )
    public ResponseEntity<Object> getProductByID(@PathVariable("id") Long id){
        Customer customer=customerService.findById(id);
        if(customer != null){
            return new ResponseEntity<>( customer ,HttpStatus.OK);
        }
        return new ResponseEntity<>( "Customer Not FOund" ,HttpStatus.NOT_FOUND );
        
    }

    // create [POST] -> customers/
    @ApiOperation(value="create a customer", code=200 )
    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Customer customer) {
        customerService.create(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // update [PUT] -> customers/{id}

    @RequestMapping(value ="/{id}", method =RequestMethod.PUT)
    @ApiOperation(value="modify a customer", code=200)
    public ResponseEntity<Object>updateCostomer(@PathVariable("id") Long id, @RequestBody Customer customer){       
        customerService.update(customer, id);
        return new ResponseEntity<>(customerService.findById(id) , HttpStatus.OK);
    }

    
    // delete [DELETE] -> customers/{id}
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value="delete a customer", code=200)
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        customerToDelete=customerService.delete(id);
        return new ResponseEntity<>(customerToDelete, HttpStatus.OK);
    }


}
