package com.eshop.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "E_SHOP_USER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EShopUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Double balance;
}
