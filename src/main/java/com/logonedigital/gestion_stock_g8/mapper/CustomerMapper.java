package com.logonedigital.gestion_stock_g8.mapper;

import com.logonedigital.gestion_stock_g8.dto.CustomerReqDTO;
import com.logonedigital.gestion_stock_g8.dto.CustomerResDTO;
import com.logonedigital.gestion_stock_g8.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface CustomerMapper {

    Customer getCustomerFromCustomerReqDTO(CustomerReqDTO customerReqDTO);
    CustomerResDTO getCustomerResDTOFromCustomer(Customer customer);
}
