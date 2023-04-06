package com.example.simpleaff.controller;

import com.example.simpleaff.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        model.addAttribute("items", productService.getCartItems());
        return "view-cart";
    }

}
