package com.smartcafe.smartcafe.repository;

import com.smartcafe.smartcafe.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}