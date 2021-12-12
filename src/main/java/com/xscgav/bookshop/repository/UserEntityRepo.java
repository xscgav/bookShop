package com.xscgav.bookshop.repository;

import com.xscgav.bookshop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepo extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmail(String email);
}
