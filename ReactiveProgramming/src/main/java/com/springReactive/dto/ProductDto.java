package com.springReactive.dto;

public class ProductDto {
    private String id;
    private String name;
    private String qty;
    private double price;

    public ProductDto(){

    }
    public ProductDto(String name, String qty, double price) {
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
}
