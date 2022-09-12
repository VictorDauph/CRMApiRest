package com.m2i.crm.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.m2i.crm.serializers.CustomerSerializer;
import com.m2i.crm.serializers.OrderSerializer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@JsonSerialize(using=OrderSerializer.class)
@Table(name="orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    private String type;

    @Column
    private String label;
    
    private int numberOfDays;
    
    private double unitPrice;
    
    private double totalExcludeTaxe;
    
    private double totalWithTaxe;
    
    @Column
    private Status status;

    public void copy(Order dataToUpdate) {
        if (dataToUpdate.getCustomer() != null) {
            this.setCustomer(dataToUpdate.getCustomer());
        }
        if (dataToUpdate.getType() != null) {
            this.setType(dataToUpdate.getType());
        }
        if (dataToUpdate.getLabel() != null) {
            this.setLabel(dataToUpdate.getLabel());
        }
        if ((Integer)dataToUpdate.getNumberOfDays() != null) {
            this.setNumberOfDays(dataToUpdate.getNumberOfDays());
        }
        if ((Double)dataToUpdate.getUnitPrice() != null) {
            this.setUnitPrice(dataToUpdate.getUnitPrice());
        }
        if ((Double)dataToUpdate.getTotalExcludeTaxe() != null) {
            this.setTotalExcludeTaxe(dataToUpdate.getTotalExcludeTaxe());
        }
        if ((Double)dataToUpdate.getTotalWithTaxe() != null) {
            this.setTotalWithTaxe(dataToUpdate.getTotalWithTaxe());
        }
        //ajouter le status
        if((Status)dataToUpdate.getStatus() != null ){
            this.setStatus(dataToUpdate.getStatus());
        }
    }
}
