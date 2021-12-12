package com.xscgav.bookshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order")
@Data
public class OrderEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
