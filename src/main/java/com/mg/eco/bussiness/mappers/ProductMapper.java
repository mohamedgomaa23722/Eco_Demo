package com.mg.eco.bussiness.mappers;

import com.mg.eco.bussiness.dtos.ProductDto;
import com.mg.eco.persistence.entity.Product;
import com.mg.eco.presentation.dtos.InsertProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "default")
public interface ProductMapper extends BaseMapper<Product, ProductDto>{
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto fromInsertObject(InsertProductDto insertUserDto);

}
