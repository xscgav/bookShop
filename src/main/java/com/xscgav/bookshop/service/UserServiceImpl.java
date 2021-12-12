package com.xscgav.bookshop.service;

import com.xscgav.bookshop.entity.UserEntity;
import com.xscgav.bookshop.repository.UserEntityRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.xscgav.bookshop.entity.UserRole.CUSTOMER;
import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserEntityRepo userEntityRepo;

    @Override
    public UserEntity findOrCreateUser(String name, String surname, String email, String phone, String address) {
        UserEntity userEntity = userEntityRepo.findByEmail(email);
        if (nonNull(userEntity)){
            return userEntity;
        }
        userEntity = new UserEntity();
        userEntity.setRole(CUSTOMER.name());
        userEntity.setAddress(address);
        userEntity.setSurname(surname);
        userEntity.setName(name);
        userEntity.setPhone(phone);
        userEntity.setEmail(email);
        return userEntityRepo.save(userEntity);
    }
}
