package com.eshop.service;

import com.eshop.model.entity.EShopUser;
import com.eshop.model.web.EShopUserRequest;

public interface EShopUserService {

    EShopUser create(EShopUserRequest request);
    EShopUser getById(Integer id);
}
