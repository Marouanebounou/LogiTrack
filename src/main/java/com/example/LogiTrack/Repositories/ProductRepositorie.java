package com.example.LogiTrack.Repositories;

import com.example.LogiTrack.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepositorie extends JpaRepository<Product , Integer> {
    @Query("select p from Product p where p.category=:category")
    List<Product> findProductsByCategory(@Param("category") String category);

    @Query("select p from Product p where p.quantity > :quantity")
    List<Product> findProductsMoreThan(@Param("quantity") int quantity);

    @Query("select p from Product p where p.price < :price")
    List<Product> findProductLessThan(@Param("price")BigDecimal price);

}
