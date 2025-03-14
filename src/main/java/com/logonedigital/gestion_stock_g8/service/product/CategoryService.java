package com.logonedigital.gestion_stock_g8.service.product;

import com.logonedigital.gestion_stock_g8.dto.CategoryReqDTO;
import com.logonedigital.gestion_stock_g8.entities.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(CategoryReqDTO categoryReqDTO);
    Category getCategory(int id);
    List<Category> getCategories();
    void updateCategory(CategoryReqDTO categoryReqDTO);
    void deleteCategory(int id);
}
