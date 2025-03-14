package com.logonedigital.gestion_stock_g8.dto;


public record ProductResDTO (
         Integer productId,
         String name,
         String description,
         String slug,
         CategoryResDTO categoryResDTO
){

}
