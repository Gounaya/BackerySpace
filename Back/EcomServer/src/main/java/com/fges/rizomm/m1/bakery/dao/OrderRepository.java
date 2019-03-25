package com.fges.rizomm.m1.bakery.dao;

import com.fges.rizomm.m1.bakery.entites.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}