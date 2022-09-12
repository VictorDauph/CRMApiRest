package com.m2i.crm.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.m2i.crm.serializers.CustomerSerializer;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@JsonSerialize(using=CustomerSerializer.class)
@Table(name="customers")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;


    @OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
    private List<Order> orders;

    @Column
    private String lastName;

    @Column
    private String firstName;

    private String company;

    @Column
    private String mail;

    private String phone;
    
    private String address;
    
    private String zipCode;
    
    private String city;
    
    private String country;

    private Active active;

    public void copy(Customer customer) {
        if (customer.getAddress() != null) {
            this.address = customer.getAddress();
        }
        if (customer.getCity() != null) {
            this.city = customer.getCity();
        }
        if (customer.getCompany()!= null) {
            this.company = customer.getCompany();
        }
        
        if (customer.getCountry()!= null) {
            this.country = customer.getCountry();
        }
        if (customer.getFirstName()!= null) {
            this.firstName = customer.getFirstName();
        }
        if (customer.getLastName()!= null) {
            this.lastName = customer.getLastName();
        }
        if (customer.getMail()!= null) {
            this.mail = customer.getMail();
        }
        if (customer.getPhone()!= null) {
            this.phone = customer.getPhone();
        }
        if (customer.getZipCode()!= null) {
            this.zipCode = customer.getZipCode();
        }
         
        if(customer.getActive() != null){
            this.active= customer.getActive();
        }
        
        
       
        
        
               
    }
 
}
