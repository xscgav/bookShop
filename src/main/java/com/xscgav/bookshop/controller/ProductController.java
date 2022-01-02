package com.xscgav.bookshop.controller;

import com.xscgav.bookshop.entity.ProductEntity;
import com.xscgav.bookshop.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts(){
        log.info("get all products request in progress");
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public ProductEntity findById(@PathVariable Integer id){
        log.info("get product by id: {} in progress", id);
        return productService.findById(id);
    }
}
