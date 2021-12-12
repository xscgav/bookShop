package com.xscgav.bookshop.entity;

import com.xscgav.bookshop.entity.enums.UserStatus;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

    public static Object setPassword;
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String surname;
    private String email;
    private String phone;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String password;

    @Enumerated
    private UserRole role;
    private String address;

    @Enumerated
    private UserStatus status;

}
