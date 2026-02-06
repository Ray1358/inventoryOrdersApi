package com.ramonbaez.inventoryordersapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

/*
 * @Entity tells Spring/JPA that this class represents
 * a database table.
 */
@Entity

/*
 * @Table lets us control the table name.
 * This will create a table called "products" in MySQL.
 */
@Table(name = "products")
public class Product {

    /*
     * @Id marks this field as the primary key.
     * @GeneratedValue means MySQL will auto-increment it.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Product name (cannot be null or blank).
     */
    @NotBlank
    @Column(nullable = false)
    private String name;

    /*
     * SKU = unique identifier for the product.
     * Marked unique so no two products share the same SKU.
     */
    @NotBlank
    @Column(nullable = false, unique = true)
    private String sku;

    /*
     * Number of items in stock.
     * @Min(0) prevents negative inventory values.
     */
    @Min(0)
    @Column(nullable = false)
    private int stockQty;

    /*
     * Price of the product.
     * BigDecimal is used for money to avoid rounding errors.
     */
    @Min(0)
    @Column(nullable = false)
    private BigDecimal price;

    // =====================
    // Getter & Setter Methods
    // =====================

    /*
     * Getter for product ID.
     * Used when reading product data from the database.
     */
    public Long getId() {
        return id;
    }

    /*
     * Getter for product name.
     */
    public String getName() {
        return name;
    }

    /*
     * Setter for product name.
     * Called when creating or updating a product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Getter for SKU.
     */
    public String getSku() {
        return sku;
    }

    /*
     * Setter for SKU.
     * Used when assigning a unique product identifier.
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /*
     * Getter for current stock quantity.
     * Used when checking inventory levels.
     */
    public int getStockQty() {
        return stockQty;
    }

    /*
     * Setter for stock quantity.
     * Used when restocking or reducing inventory.
     */
    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    /*
     * Getter for product price.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /*
     * Setter for product price.
     * Used when creating or updating product pricing.
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
