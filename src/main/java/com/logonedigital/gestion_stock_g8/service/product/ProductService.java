package com.logonedigital.gestion_stock_g8.service.product;

import com.logonedigital.gestion_stock_g8.dto.ProductReqDTO;
import com.logonedigital.gestion_stock_g8.dto.ProductResDTO;
import com.logonedigital.gestion_stock_g8.entities.Product;

import java.util.List;

public interface ProductService {
    void addProduct(ProductReqDTO productReqDTO);
    List<ProductResDTO> getProducts();
}
