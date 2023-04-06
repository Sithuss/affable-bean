package com.example.simpleaff.ds;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter @Setter
public class CartItem {
    private Integer id;
    private String name;
    private double price;
    private int quantity;

    public CartItem(Integer id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public CartItem() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItem cartItem)) return false;
        return id.equals(cartItem.id) && name.equals(cartItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
