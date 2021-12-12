package com.xscgav.bookshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "purchase_item")
@Data
public class PurchaseItemEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer count;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;
}
