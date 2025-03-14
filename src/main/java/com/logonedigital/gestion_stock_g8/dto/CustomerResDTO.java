package com.logonedigital.gestion_stock_g8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResDTO {
    private Integer customerId;
    private String firstname;
    private String lastname;
    private String email;
}
