package com.xscgav.bookshop.service;

import com.xscgav.bookshop.entity.UserEntity;
import com.xscgav.bookshop.entity.enums.UserStatus;
import com.xscgav.bookshop.repository.UserEntityRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import static com.xscgav.bookshop.entity.UserRole.CUSTOMER;
import static com.xscgav.bookshop.entity.enums.UserStatus.ACTIVE;
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
        userEntity.setRole(CUSTOMER);
        userEntity.setAddress(address);
        userEntity.setSurname(surname);
        userEntity.setName(name);
        userEntity.setPhone(phone);
        userEntity.setEmail(email);
        return userEntityRepo.save(userEntity);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userEntityRepo.findByEmail(email);
    }

    @Override
    public UserEntity findBYEmailAndPassword(String email, String password) {
        UserEntity userEntity = findByEmail(email);
        if (userEntity != null) {
            if (password.equals(userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

    @Override
    public void setPassword(Integer userId, String password) {
        UserEntity userEntity = userEntityRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User doesnt exist"));
        userEntity.setPassword(password);
        userEntity.setStatus(ACTIVE);

    }
}
