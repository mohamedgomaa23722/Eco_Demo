package com.mg.eco.persistence.repository;

import com.mg.eco.persistence.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends BaseRepository<Product>{
    public ProductRepository() {
        super(Product.class);
    }
}
