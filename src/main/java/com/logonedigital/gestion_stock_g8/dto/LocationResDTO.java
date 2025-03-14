package com.logonedigital.gestion_stock_g8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationResDTO {
    private Integer locationId;
    private String town;
    private String street;
    private Integer postalCode;
}
