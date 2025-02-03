package com.logonedigital.gestion_stock_g8.service.Invoice;

import com.logonedigital.gestion_stock_g8.entities.Invoice;
import com.logonedigital.gestion_stock_g8.exception.ResourceNotFoundException;
import com.logonedigital.gestion_stock_g8.repositories.InvoiceRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    private final InvoiceRepo invoiceRepo;

    public InvoiceServiceImpl(InvoiceRepo invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }

    @Override
    public void addInvoice(Invoice invoice) {
        invoice.setCreatedAt(new Date());
        invoice.setStatus(true);
        this.invoiceRepo.save(invoice);
    }

    @Override
    public Invoice getInvoiceById(int id) {
        return invoiceRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Invoice id not found"));
    }

    @Override
    public Invoice getInvoiceByReference(String reference) {
        return invoiceRepo.findByReference(reference)
                .orElseThrow(()-> new ResourceNotFoundException("Invoice with reference: " + reference + " not found !"));
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepo.findAll();
    }

    /*@Override
    public List<Invoice> getInvoicesByStatus(Boolean status) {
        return invoiceRepo.findByStatus(status);
    }*/

    @Override
    public void updateInvoice(Integer id, Invoice invoice) {
        Invoice updatedInvoice = (Invoice) this.invoiceRepo;
        invoice = invoiceRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Invoice not found"));
        invoice.setReference(updatedInvoice.getReference());
        invoice.setUpdatedAt(new Date());
        invoice.setStatus(updatedInvoice.getStatus());

        invoiceRepo.save(invoice);
    }

    @Override
    public void deleteInvoice(Integer id) {
        if (!invoiceRepo.existsById(id)){
            throw new ResourceNotFoundException("Invoice not found with ID: " +id);
        }
        invoiceRepo.deleteById(id);
    }


}