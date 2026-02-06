package com.ramonbaez.inventoryordersapi.repository;

import com.ramonbaez.inventoryordersapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
