package com.eshop.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "E_SHOP_PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String displayName;

    private String description;

    private Double price;

    private Integer discount;

    private Integer quantity;

    @ManyToOne
    private EShopUser seller;

    @ManyToOne
    private Category category;
}
