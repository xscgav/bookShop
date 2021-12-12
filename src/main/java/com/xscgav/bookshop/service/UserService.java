package com.xscgav.bookshop.service;

import com.xscgav.bookshop.entity.UserEntity;

public interface UserService {

    UserEntity findOrCreateUser(String name, String surname, String email, String phone, String address);

    UserEntity findByEmail(String email);

    UserEntity findBYEmailAndPassword(String email, String password);

    void setPassword(Integer userId, String password);
}
