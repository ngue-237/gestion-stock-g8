package com.logonedigital.gestion_stock_g8.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryResDTO {
    private Integer categoryId;
    private String name;
    private String description;
    private String slug;
}
