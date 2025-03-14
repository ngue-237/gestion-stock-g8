package com.logonedigital.gestion_stock_g8.controller;

import com.logonedigital.gestion_stock_g8.dto.CategoryReqDTO;
import com.logonedigital.gestion_stock_g8.entities.Category;
import com.logonedigital.gestion_stock_g8.service.product.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(path = "category/add")
    public ResponseEntity<String> addCategory(CategoryReqDTO categoryReqDTO){
        this.categoryService.addCategory(categoryReqDTO);
        return ResponseEntity.status(201)
                .body("Created successfully !");
    }

    @GetMapping(path = "category/get_all")
    public ResponseEntity<List<Category>> getCategories(){
        return ResponseEntity
                .status(200)
                .body(this.categoryService.getCategories());
    }
}
