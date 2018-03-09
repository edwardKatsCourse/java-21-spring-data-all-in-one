package com.eshop.service;

import com.eshop.exception.InputValidationException;
import com.eshop.exception.UserNotFoundException;
import com.eshop.model.entity.EShopUser;
import com.eshop.model.web.EShopUserRequest;
import com.eshop.repository.EShopUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EShopUserServiceImpl implements EShopUserService {

    @Autowired
    private EShopUserRepository userRepository;

    @Override
    public EShopUser create(EShopUserRequest request) {
        EShopUser eShopUser = userRepository.findByEmail(request.getEmail());
        if (eShopUser != null) {
            String errorMessage = String.format("Email [%s] is already present in the system", request.getEmail());
            throw new InputValidationException("email", errorMessage);
        }

        eShopUser = EShopUser.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .balance(0.00)
                .build();
        return userRepository.save(eShopUser);
    }

    @Override
    public EShopUser getById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID [" + id + "] not found"));
    }
}

//class CheckedException extends Exception {
//    public CheckedException(String message) {
//        super(message);
//    }
//}
//
//class UnCheckedException extends RuntimeException {
//    public UnCheckedException(String message) {
//        super(message);
//    }
//}
//
//class DemoRunner {
//    public static void main(String[] args) {
//        if (true) {
//            throw new CheckedException("My message");
//        }
//
//        if (true) {
//            throw new UnCheckedException("My message");
//        }
//    }
//}
















