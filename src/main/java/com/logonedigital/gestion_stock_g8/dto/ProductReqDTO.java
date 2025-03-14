package com.logonedigital.gestion_stock_g8.dto;

public record ProductReqDTO (
        String name,
        String description,
        Double price,
        Integer categoryId
) {
}
