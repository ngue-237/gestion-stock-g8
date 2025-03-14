package com.logonedigital.gestion_stock_g8.service.customer;

import com.logonedigital.gestion_stock_g8.dto.CustomerReqDTO;
import com.logonedigital.gestion_stock_g8.dto.CustomerResDTO;
import com.logonedigital.gestion_stock_g8.entities.Customer;
import com.logonedigital.gestion_stock_g8.entities.Location;
import com.logonedigital.gestion_stock_g8.exception.ResourceExistException;
import com.logonedigital.gestion_stock_g8.exception.ResourceNotFoundException;
import com.logonedigital.gestion_stock_g8.mapper.CustomerMapper;
import com.logonedigital.gestion_stock_g8.mapper.LocationMapper;
import com.logonedigital.gestion_stock_g8.repositories.CustomerRepo;
import com.logonedigital.gestion_stock_g8.repositories.LocationRepo;
import com.logonedigital.gestion_stock_g8.service.location.LocationService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    private final LocationService locationService;
    private final LocationMapper locationMapper;

    public CustomerServiceImpl(CustomerRepo customerRepo, CustomerMapper customerMapper, LocationService locationService, LocationMapper locationMapper
    ) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
        this.locationService = locationService;
        this.locationMapper = locationMapper;
    }

    @Override
    public void addCustomer(CustomerReqDTO customerReqDTO) {

        Optional<Customer> customerToSave = this.customerRepo
                .findByEmail(customerReqDTO.getEmail());
        if (customerToSave.isPresent())
            throw new ResourceExistException("This email already exist !");
        Customer customer = this.customerMapper.getCustomerFromCustomerReqDTO(customerReqDTO);
        customer.setLocation(
                this.locationMapper
                .getLocationFromLocationReqDTO(customerReqDTO
                        .getLocationReqDTO()));
        customer.setCreatedAt(new Date());
        customer.setStatus(true);

        //save location
        this.locationService.addLocation(customerReqDTO.getLocationReqDTO());


        this.customerRepo.save(customer);
    }

    @Override
    public CustomerResDTO getCustomer(int id) {
        Customer customer = this.customerRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Not found !")
        );
        return this.customerMapper.getCustomerResDTOFromCustomer(customer);
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
