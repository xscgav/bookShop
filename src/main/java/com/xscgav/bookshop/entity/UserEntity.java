package com.xscgav.bookshop.entity;

import com.xscgav.bookshop.entity.enums.UserStatus;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@ToString(exclude = "password")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private String email;
    private String phone;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
    private String address;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

}
