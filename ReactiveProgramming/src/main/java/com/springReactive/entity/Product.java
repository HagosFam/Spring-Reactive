package com.springReactive.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private String id;
    private String name;
    private String qty;
    private double price;


    public Product() {
    }

    public Product(String name, String qty, double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }
}
