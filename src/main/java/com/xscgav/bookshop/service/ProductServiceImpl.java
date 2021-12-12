package com.xscgav.bookshop.service;

import com.xscgav.bookshop.entity.ProductEntity;
import com.xscgav.bookshop.exception.NotFoundException;
import com.xscgav.bookshop.repository.ProductEntityRepo;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductEntityRepo productEntityRepo;

    @Override
    public List<ProductEntity> findAll() {
        return productEntityRepo.findAll();
    }

    @Override
    @SneakyThrows
    public ProductEntity findById(Integer id) {
        return productEntityRepo.findById(id).orElseThrow(() -> new NotFoundException("Product isn't available"));
    }
}
