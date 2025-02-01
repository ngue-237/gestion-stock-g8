package com.logonedigital.gestion_stock_g8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorMessage {
    private Integer statusCode;
    private Date timestamp;
    private String message;
    private String error;
}
