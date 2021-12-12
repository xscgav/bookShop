package com.xscgav.bookshop.repository;

import com.xscgav.bookshop.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityRepo extends JpaRepository<ProductEntity, Integer> {
}
