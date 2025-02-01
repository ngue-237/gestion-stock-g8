package com.logonedigital.gestion_stock_g8.repositories;

import com.logonedigital.gestion_stock_g8.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location,Integer> {
}
