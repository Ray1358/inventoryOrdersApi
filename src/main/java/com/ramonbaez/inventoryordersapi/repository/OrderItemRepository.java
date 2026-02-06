package com.ramonbaez.inventoryordersapi.repository;

import com.ramonbaez.inventoryordersapi.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
