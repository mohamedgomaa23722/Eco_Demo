package com.mg.eco.bussiness.services;

import com.mg.eco.bussiness.dtos.ProductDto;
import com.mg.eco.bussiness.mappers.ProductMapper;
import com.mg.eco.persistence.entity.Product;
import com.mg.eco.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends BaseService<Product, ProductDto>{

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        super(repository, ProductMapper.INSTANCE);
    }
}
