package com.logonedigital.gestion_stock_g8.controller;

import com.logonedigital.gestion_stock_g8.dto.ProductReqDTO;
import com.logonedigital.gestion_stock_g8.dto.ProductResDTO;
import com.logonedigital.gestion_stock_g8.entities.Product;
import com.logonedigital.gestion_stock_g8.service.product.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("api/products/add")
    public ResponseEntity<String> saveProduct(@RequestBody ProductReqDTO productReqDTO){
        this.productService.addProduct(productReqDTO);
        return ResponseEntity.status(201)
                .body("Product created!");
    }

    @GetMapping("api/products/get_all")
    public ResponseEntity<List<ProductResDTO>> getProducts(){

        return ResponseEntity.status(200)
                .body(this.productService.getProducts());
    }
}
