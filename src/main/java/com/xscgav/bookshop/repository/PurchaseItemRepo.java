package com.xscgav.bookshop.repository;

import com.xscgav.bookshop.entity.PurchaseItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseItemRepo extends JpaRepository<PurchaseItemEntity, Integer> {
}
