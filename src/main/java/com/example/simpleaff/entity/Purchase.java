package com.example.simpleaff.entity;

import com.example.simpleaff.ds.CartItem;
import com.example.simpleaff.validation.CreditCard;
import com.example.simpleaff.validation.OnlyNumbers;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;
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
    @NotEmpty(message = "name cannot be empty")
    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotEmpty(message = "name cannot be empty")
    @NotBlank(message = "name cannot be blank")
    @Email(message = "invalid email format")
    private String email;
    @NotEmpty(message = "phone cannot be empty")
    @OnlyNumbers(message = "phone number can only contain numbers")
    private String phone;
    private String address;
    @NotEmpty(message = "Please input credit card number!")
    @CreditCard(message = "invalid credit card format")
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
