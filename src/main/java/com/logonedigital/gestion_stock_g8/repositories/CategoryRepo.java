package com.logonedigital.gestion_stock_g8.repositories;

import com.logonedigital.gestion_stock_g8.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
