package com.ramonbaez.inventoryordersapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String sku;

    @Min(0)
    @Column(nullable = false)
    private int stockQty;

    @Min(0)
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public int getStockQty() { return stockQty; }
    public void setStockQty(int stockQty) { this.stockQty = stockQty; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
