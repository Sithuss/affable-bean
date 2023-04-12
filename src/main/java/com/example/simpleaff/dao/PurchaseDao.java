package com.example.simpleaff.dao;

import com.example.simpleaff.entity.ProductItem;
import com.example.simpleaff.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseDao extends JpaRepository<Purchase, Integer> {

    public Purchase findPurchaseByEmailAndPurchaseDateTime(String email, LocalDateTime dateTime);

}
