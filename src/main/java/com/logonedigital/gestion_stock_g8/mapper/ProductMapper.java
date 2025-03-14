package com.logonedigital.gestion_stock_g8.mapper;

import com.logonedigital.gestion_stock_g8.dto.ProductReqDTO;
import com.logonedigital.gestion_stock_g8.dto.ProductResDTO;
import com.logonedigital.gestion_stock_g8.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring")
public interface ProductMapper {
    Product fromProductReqDTO(ProductReqDTO productReqDTO);
    ProductResDTO fromProduct(Product product);
}
