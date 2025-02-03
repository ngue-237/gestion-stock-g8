package com.logonedigital.gestion_stock_g8.controller;

import com.logonedigital.gestion_stock_g8.entities.Invoice;
import com.logonedigital.gestion_stock_g8.service.Invoice.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping(path = "api/invoice/add")
    public ResponseEntity<String> addInvoice(@RequestBody Invoice invoice) {
        invoiceService.addInvoice(invoice);
        return ResponseEntity.ok("Invoice added successfully!");
    }

    @GetMapping(path = "api/invoice/get_by_id/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Integer id) {
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }

    @GetMapping(path= "/reference/{reference}")
    public ResponseEntity<Invoice> getInvoiceByReference(@PathVariable String reference) {
        return ResponseEntity.ok(invoiceService.getInvoiceByReference(reference));
    }

    @GetMapping(path = "api/invoice/get_all")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

   /* @GetMapping(path="/status/{status}")
    public ResponseEntity<List<Invoice>> getInvoicesByStatus(@PathVariable Boolean status) {
        return ResponseEntity.ok(invoiceService.getInvoicesByStatus(status));
    }*/

    @PutMapping(path="api/invoice/update_by_id/{id}")
    public ResponseEntity<String> updateInvoice(@PathVariable Integer id, @RequestBody Invoice invoice) {
        invoiceService.updateInvoice(id, invoice);
        return ResponseEntity.ok("Invoice updated successfully!");
    }

    @DeleteMapping(path="api/invoice/delete_by_id/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Integer id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.ok("Invoice deleted successfully!");
    }
}
