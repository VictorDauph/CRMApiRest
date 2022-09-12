package com.m2i.crm.service;

import java.util.List;

import com.m2i.crm.model.Order;
import java.util.Optional;

import javassist.NotFoundException;

public interface IOrderService {
    List<Order> findAll();
    Optional<Order> findById(Long id);
    void create(Order order);
    void update(Order order, Long id) throws NotFoundException;
    Order delete(Long id);
}
