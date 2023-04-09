package com.example.simpleaff.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class ProductItem {

    private Integer id;
    private String name;
    private double price;
    private int quantity;
    private double total;

    public ProductItem(Integer id, String name, double price, int quantity, double total) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public ProductItem() {
    }
}
