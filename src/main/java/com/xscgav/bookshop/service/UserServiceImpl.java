package com.xscgav.bookshop.service;

import com.xscgav.bookshop.entity.UserEntity;
import com.xscgav.bookshop.entity.enums.UserStatus;
import com.xscgav.bookshop.repository.UserEntityRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static com.xscgav.bookshop.entity.UserRole.CUSTOMER;
import static com.xscgav.bookshop.entity.enums.UserStatus.ACTIVE;
import static com.xscgav.bookshop.entity.enums.UserStatus.DISABLED;
import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserEntityRepo userEntityRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity findOrCreateUser(String name, String surname, String phone, String email, String address) {
        UserEntity userEntity = userEntityRepository.findByEmail(email);
        if (nonNull(userEntity)) {
            return userEntity;
        }
        userEntity = new UserEntity();
        userEntity.setRole(CUSTOMER);
        userEntity.setStatus(DISABLED);
        userEntity.setAddress(address);
        userEntity.setSurname(surname);
        userEntity.setName(name);
        userEntity.setPhone(phone);
        userEntity.setEmail(email);
        return userEntityRepository.save(userEntity);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userEntityRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByEmailAndPassword(String email, String password) {
        UserEntity userEntity = findByEmail(email);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

    @Override
    public void setPassword(Integer userId, String password) {
        UserEntity userEntity = userEntityRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User with id: " + userId + "not found"));
        userEntity.setPassword(passwordEncoder.encode(password));
        userEntity.setStatus(ACTIVE);
        userEntityRepository.save(userEntity);
    }
}