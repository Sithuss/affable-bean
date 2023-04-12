package com.example.simpleaff.controller;

import com.example.simpleaff.ds.CartItem;
import com.example.simpleaff.entity.ProductItem;
import com.example.simpleaff.entity.Purchase;
import com.example.simpleaff.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ProductController {

    private final int deliCharge = 3;
    @Autowired
    private ProductService productService;

    private String pullEmail;

    private LocalDateTime dateTime;

    @GetMapping({"/home", "/"})
    public String home() {
        return "home";
    }

    @GetMapping("/products")
    public String listProductsByCategory(@RequestParam("cid") int cid, Model model) {
        model.addAttribute("products", productService.listProducts(cid));
        return "products";
    }

    @GetMapping("/add-cart")
    public String addCart(@RequestParam("id")int id, Model model) {
        int catId = productService.findCategoryId(id);
        productService.addToCart(id);
        return "redirect:/products?cid=" + catId;
    }

    @ModelAttribute("cartSize")
    public int cartSize(){
        return productService.cartSize();
    }

    @GetMapping("/cart-view")
    public String viewCart(Model model) {
        model.addAttribute("cartItem", new CartItem());
        model.addAttribute("cartItems", productService.getCartItems());
        return "view-cart";
    }

    @ModelAttribute("subtotal")
    public double subTotal() {
        return productService.getCartItems()
                .stream()
                .mapToDouble(CartItem::getTotal)
                .sum();
    }

    @ModelAttribute("total")
    public double total() {
        return subTotal() + deliCharge;
    }

    @PostMapping("/update-cart")
    public String updateCart(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("price") double price,
                             @RequestParam("quantity") int quantity) {

        productService.updateCart(id, name, price, quantity);
        return "redirect:/cart-view";
    }

    @GetMapping("/clear-cart")
    public String clearCart() {
        productService.clearCart();
        return "redirect:/cart-view";
    }

    @GetMapping("/checkout")
    public String checkOut(Model model) {
        model.addAttribute("toggle", true);
        model.addAttribute("purchase" , new Purchase());
       return "checkout";
    }

    @PostMapping("/checkout")
    public String addPurchase(Purchase purchase, Model model) {
        model.addAttribute("toggle", false);
        dateTime = LocalDateTime.now();
        productService.addPurchase(purchase, dateTime);
        pullEmail = purchase.getEmail();
        productService.clearCart();
        return "redirect:/confirm";
    }

    @GetMapping("/confirm")
    public String confirm(Model model) {
        model.addAttribute("purchased", productService.findPurchase(pullEmail, dateTime));
        model.addAttribute("productItems", productService.findPurchase(pullEmail, dateTime).getProductItems());
        return "confirm";
    }

}
