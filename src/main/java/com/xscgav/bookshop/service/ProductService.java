package com.xscgav.bookshop.service;

import com.xscgav.bookshop.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> findAll();

    ProductEntity findById(Integer id);
}
