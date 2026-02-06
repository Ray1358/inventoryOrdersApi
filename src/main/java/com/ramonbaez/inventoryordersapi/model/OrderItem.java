package com.ramonbaez.inventoryordersapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Prevent infinite JSON recursion (Order -> items -> order -> items...)
    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Order order;

    // EAGER so Product info can serialize easily in responses
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Product product;

    @Min(1)
    @Column(nullable = false)
    private int qty;

    // snapshot unit price at time item added
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    public Long getId() { return id; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }
}
