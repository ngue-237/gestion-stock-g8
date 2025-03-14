package com.logonedigital.gestion_stock_g8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record CategoryReqDTO (
     String name,
     String description
){}
