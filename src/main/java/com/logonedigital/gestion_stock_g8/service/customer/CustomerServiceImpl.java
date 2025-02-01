package com.logonedigital.gestion_stock_g8.service.customer;

import com.logonedigital.gestion_stock_g8.entities.Customer;
import com.logonedigital.gestion_stock_g8.exception.ResourceExistException;
import com.logonedigital.gestion_stock_g8.exception.ResourceNotFoundException;
import com.logonedigital.gestion_stock_g8.repositories.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public void addCustomer(Customer customer) {
        Optional<Customer> customerToSave = this.customerRepo
                .findByEmail(customer.getEmail());
        if (customerToSave.isPresent())
            throw new ResourceExistException("This email already exist !");

        customer.setCreatedAt(new Date());
        customer.setStatus(true);
        this.customerRepo.save(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        return this.customerRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Not found !")
        );
    }

    @Override
    public List<Customer> getCustomers() {
        return this.customerRepo.findAll();
    }

    @Override
    public void updateCustomer(Integer customerId, Customer customer) {
        Customer customerToUpdate = this.customerRepo.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Not found !"));

        customerToUpdate.setFirstname(customer.getFirstname());
        customerToUpdate.setLastname(customer.getLastname());
        customerToUpdate.setEmail(customer.getEmail());

        customerToUpdate.setUpdatedAt(new Date());

        this.customerRepo.saveAndFlush(customerToUpdate);

    }

    @Override
    public void deleteCustomer(Integer customerId) {
        Customer customer = this.customerRepo.findById(customerId)
                .orElseThrow(()->new ResourceNotFoundException("Not found !"));
        this.customerRepo.delete(customer);
    }
}
