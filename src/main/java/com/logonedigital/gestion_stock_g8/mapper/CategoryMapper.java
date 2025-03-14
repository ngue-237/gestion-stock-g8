package com.logonedigital.gestion_stock_g8.mapper;

import com.logonedigital.gestion_stock_g8.dto.CategoryReqDTO;
import com.logonedigital.gestion_stock_g8.dto.CategoryResDTO;
import com.logonedigital.gestion_stock_g8.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category fromCategoryReqDTO(CategoryReqDTO categoryReqDTO);
    CategoryResDTO fromCategory(Category category);
}
