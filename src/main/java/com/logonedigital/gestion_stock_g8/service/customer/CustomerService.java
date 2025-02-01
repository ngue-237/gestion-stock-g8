package com.logonedigital.gestion_stock_g8.service.customer;

import com.logonedigital.gestion_stock_g8.entities.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    Customer getCustomer(int id);
    List<Customer> getCustomers();
    void updateCustomer(Integer customerId, Customer customer);
    void deleteCustomer(Integer customerId);
}
