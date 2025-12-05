package com.parham.online_shop.repository;

import com.parham.online_shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
}
