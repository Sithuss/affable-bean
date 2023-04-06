package com.example.simpleaff.ds;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

@Component
@SessionScope
public class Cart {

    Set<CartItem> cartItems = new HashSet<>();

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addToCart(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public void clearCart() {
        this.cartItems.clear();
    }

    public int cartSize() {
        return this.cartItems.size();
    }

}