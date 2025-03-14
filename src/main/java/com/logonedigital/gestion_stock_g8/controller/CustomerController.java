package com.logonedigital.gestion_stock_g8.controller;

import com.logonedigital.gestion_stock_g8.dto.CustomerReqDTO;
import com.logonedigital.gestion_stock_g8.dto.CustomerResDTO;
import com.logonedigital.gestion_stock_g8.entities.Customer;
import com.logonedigital.gestion_stock_g8.service.customer.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = "api/customer/add")
    public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerReqDTO customerReqDTO){
        this.customerService.addCustomer(customerReqDTO);
        return ResponseEntity
                .status(201)
                .body("Customer created successfully !");
    }

    @GetMapping(path = "api/customer/get_all")
    public ResponseEntity<List<Customer>>getCustomers(){

        return ResponseEntity
                .status(200)
                .body(this.customerService.getCustomers());
    }

    @GetMapping(path = "api/customer/get_by_id/{customerId}")
    public ResponseEntity<CustomerResDTO> getCustomerBy(@PathVariable Integer customerId){

        return ResponseEntity 
                .status(200)
                .body(this.customerService.getCustomer(customerId));
    }
}
