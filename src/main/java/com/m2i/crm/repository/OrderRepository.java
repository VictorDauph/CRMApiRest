package com.m2i.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m2i.crm.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
