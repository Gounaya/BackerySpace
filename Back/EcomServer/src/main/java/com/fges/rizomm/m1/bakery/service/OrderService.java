package com.fges.rizomm.m1.bakery.service;

import com.fges.rizomm.m1.bakery.entites.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    void save(Order order);
    void update(Order order);
    Optional<Order> find(Long id);
    void delete (Long id);
    List<Order> findAll();

}
