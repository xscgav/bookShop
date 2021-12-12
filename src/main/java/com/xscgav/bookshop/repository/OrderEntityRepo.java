package com.xscgav.bookshop.repository;

import com.xscgav.bookshop.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntityRepo extends JpaRepository<OrderEntity, Integer> {
}
