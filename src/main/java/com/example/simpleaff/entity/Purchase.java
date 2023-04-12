package com.example.simpleaff.entity;

import com.example.simpleaff.ds.CartItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String creditCard;

    @Column(name = "purchase_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime purchaseDateTime;

    @ElementCollection
    @CollectionTable(name = "purchase_product_items")
    private List<ProductItem> productItems = new ArrayList<>();

    public void addProductItem(ProductItem productItem) {
        this.productItems.add(productItem);
    }

}
