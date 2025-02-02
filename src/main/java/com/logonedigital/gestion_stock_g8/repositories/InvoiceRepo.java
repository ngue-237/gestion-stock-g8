package com.logonedigital.gestion_stock_g8.repositories;

import com.logonedigital.gestion_stock_g8.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface InvoiceRepo extends JpaRepository<Invoice, Integer> {
    Optional<Invoice> findByReference(String reference);
    List<Invoice> findByStatus(Boolean status);

}
