package com.xscgav.bookshop.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
@ToString(exclude = "password")
public class UserEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private String role;
    private String address;
}
