package com.logonedigital.gestion_stock_g8.service.Invoice;

import com.logonedigital.gestion_stock_g8.entities.Customer;
import com.logonedigital.gestion_stock_g8.entities.Invoice;

import java.util.List;

public interface InvoiceService {
    void addInvoice(Invoice invoice);
    Invoice getInvoiceById(int id);
    Invoice getInvoiceByReference(String reference);
    List<Invoice> getAllInvoices();
    //List<Invoice> getInvoicesByStatus(Boolean status);
    void updateInvoice(Integer id, Invoice invoice);
    void deleteInvoice(Integer id);
}
