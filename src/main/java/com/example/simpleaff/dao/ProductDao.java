package com.example.simpleaff.dao;

import com.example.simpleaff.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    @Query("""
select p from Product p where p.category.id =?1
""")
    List<Product> findProductByCategoryId(int categoryId);

    Product findProductById(int id);
}
