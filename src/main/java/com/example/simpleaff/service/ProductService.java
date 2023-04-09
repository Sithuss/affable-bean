package com.example.simpleaff.service;

import com.example.simpleaff.dao.CategoryDao;
import com.example.simpleaff.dao.ProductDao;
import com.example.simpleaff.ds.Cart;
import com.example.simpleaff.ds.CartItem;
import com.example.simpleaff.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    private final Cart cart;

    public ProductService(Cart cart) {
        this.cart = cart;
    }

    public List<Product> listProducts(int categoryId) {
        return productDao.findProductByCategoryId(categoryId);
    }


    public int findCategoryId(int id) {
        Product p = productDao.findProductById(id);

//        System.out.println(p.getClass());
        return p.getCategory().getId();

    }

    public void addToCart(int id) {
        Product product = productDao.findProductById(id);
        cart.addToCart(new CartItem(
                product.getId(),
                product.getName(),
                product.getPrice(),
                1
        ));
    }

    public int cartSize() {
        return cart.cartSize();
    }

    public Set<CartItem> getCartItems() {
        return cart.getCartItems();
    }


    public void clearCart() {
        cart.clearCart();
    }

    public void updateCart(int id, String name, double price, int quantity) {
        var cartItem = new CartItem(id, name, price, quantity);
        cart.removeItem(cartItem);
        cart.addToCart(cartItem);
    }
}
