package com.xscgav.bookshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private String image;
    private Double price;
}
