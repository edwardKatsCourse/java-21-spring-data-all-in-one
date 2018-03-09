package com.eshop.repository;

import com.eshop.model.entity.EShopUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EShopUserRepository extends JpaRepository<EShopUser, Integer> {
    EShopUser findByEmail(String email);
}
