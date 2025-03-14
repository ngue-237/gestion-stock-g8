package com.logonedigital.gestion_stock_g8.service.product;

import com.github.slugify.Slugify;
import com.logonedigital.gestion_stock_g8.dto.CategoryReqDTO;
import com.logonedigital.gestion_stock_g8.entities.Category;
import com.logonedigital.gestion_stock_g8.mapper.CategoryMapper;
import com.logonedigital.gestion_stock_g8.repositories.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
   private final CategoryRepo categoryRepo;
   private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepo categoryRepo, CategoryMapper categoryMapper) {
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void addCategory(CategoryReqDTO categoryReqDTO) {
        Category category = this.categoryMapper.fromCategoryReqDTO(categoryReqDTO);
        final Slugify slg = Slugify.builder().build();
        category.setSlug(slg.slugify(category.getName()));
        category.setCreatedAt(new Date());
        category.setStatus(true);
        this.categoryRepo.save(category);
    }

    @Override
    public Category getCategory(int id) {
        return null;
    }

    @Override
    public List<Category> getCategories() {
        return this.categoryRepo.findAll();
    }

    @Override
    public void updateCategory(CategoryReqDTO categoryReqDTO) {

    }

    @Override
    public void deleteCategory(int id) {

    }
}
