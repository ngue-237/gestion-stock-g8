package com.logonedigital.gestion_stock_g8.service.product;

import com.github.slugify.Slugify;
import com.logonedigital.gestion_stock_g8.dto.ProductReqDTO;
import com.logonedigital.gestion_stock_g8.dto.ProductResDTO;
import com.logonedigital.gestion_stock_g8.entities.Category;
import com.logonedigital.gestion_stock_g8.entities.Product;
import com.logonedigital.gestion_stock_g8.exception.ResourceNotFoundException;
import com.logonedigital.gestion_stock_g8.mapper.CategoryMapper;
import com.logonedigital.gestion_stock_g8.mapper.ProductMapper;
import com.logonedigital.gestion_stock_g8.repositories.CategoryRepo;
import com.logonedigital.gestion_stock_g8.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;
    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;

    public ProductServiceImpl(ProductRepo productRepo, ProductMapper productMapper, CategoryRepo categoryRepo, CategoryMapper categoryMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void addProduct(ProductReqDTO productReqDTO) {
        Product product = this.productMapper.fromProductReqDTO(productReqDTO);
        final Slugify slg = Slugify.builder().build();
        product.setSlug(slg.slugify(product.getName()));
        Category category = this.categoryRepo
                .findById(productReqDTO.categoryId())
                .orElseThrow(()-> new ResourceNotFoundException("Resource not found!"));
        product.setCategory(category);
        product.setCreatedAt(new Date());
        product.setStatus(true);
        this.productRepo.save(product);
    }

    @Override
    public List<ProductResDTO> getProducts() {
        List<Product> products = this.productRepo.findAll();
        return products.stream()
                .map(product ->
                     this.productMapper.fromProduct(product)
                )
                .toList();
    }
}
