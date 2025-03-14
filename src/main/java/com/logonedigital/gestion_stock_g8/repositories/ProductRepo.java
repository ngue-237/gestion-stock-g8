package com.logonedigital.gestion_stock_g8.repositories;

import com.logonedigital.gestion_stock_g8.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
