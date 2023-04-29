package com.mg.eco.presentation.api;

import com.mg.eco.bussiness.dtos.Message;
import com.mg.eco.bussiness.dtos.ProductDto;
import com.mg.eco.bussiness.mappers.ProductMapper;
import com.mg.eco.bussiness.services.ProductServiceImpl;
import com.mg.eco.presentation.dtos.InsertProductDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/products")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping
    public List<ProductDto> getProducts(@RequestParam(value = "page", defaultValue = "1") int page) {
        return productService.getAll(page);
    }

    @GetMapping("{id}")
    public ProductDto getProduct(@PathVariable("id") int id) {
        return productService.findById(id);
    }

    @PostMapping
    public Message insertUser(@Valid @RequestBody InsertProductDto insertProductDto){
        ProductDto productDto = ProductMapper.INSTANCE.fromInsertObject(insertProductDto);
        return productService.insert(productDto);
    }

    @DeleteMapping("{id}")
    public Message deleteProduct(@PathVariable("id") int id) {
        return productService.delete(id);
    }

    @GetMapping("search")
    public List<ProductDto> findProductsByName(@RequestParam("name") String userName,
                                           @RequestParam(value = "page", defaultValue = "1") int page) {
        return productService.findByName(userName, "firstName", page);
    }
}
