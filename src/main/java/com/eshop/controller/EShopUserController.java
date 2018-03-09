package com.eshop.controller;

import com.eshop.exception.InputValidationException;
import com.eshop.model.entity.EShopUser;
import com.eshop.model.web.EShopUserRequest;
import com.eshop.service.EShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/eshop/users")
public class EShopUserController {

    @Autowired
    private EShopUserService userService;

    @PostMapping("/create")
    public EShopUser create(
            @RequestBody @Valid EShopUserRequest request,
            BindingResult result) {

        if (result.hasErrors()) {
//            List<String> collect = result.getFieldErrors()
//                    .stream()
//                    .map(x ->
//                            String.format("%s: %s",
//                                    x.getField(),
//                                    x.getDefaultMessage())
//                    )
//                    .collect(Collectors.toList());
//            throw new RuntimeException(collect.toString());

            throw new InputValidationException(result);
        }
        return userService.create(request);
    }

    @GetMapping("/{userId}")
    public EShopUser getUserById(
            @PathVariable("userId") Integer userId) {
        return userService.getById(userId);
    }
}
