package com.example.simpleaff.controller;

import com.example.simpleaff.ds.CartItem;
import com.example.simpleaff.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

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
        productService.getCartItems().stream().map(CartItem::getName).forEach(System.out::println);
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

    @PostMapping("/update-cart")
    public String updateCart(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("price") double price,
                             @RequestParam("quantity") int quantity) {
        System.out.println("++++++++++post mapping+++++++++++++++");
        System.out.println("id " + id);
        System.out.println("name" + name);
        System.out.println("price " + price);
        System.out.println("quantity " + quantity);
        productService.updateCart(id, name, price, quantity);
        return "redirect:/cart-view";
    }

    @GetMapping("/clear-cart")
    public String clearCart() {
        productService.clearCart();
        return "redirect:/cart-view";
    }

}
