package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.UserPaymentMethod;
import com.sshproject.bookstore.Repository.UserPaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserPaymentMethodService implements UserPaymentMethodServiceInterface {

    @Autowired
    private UserPaymentMethodRepository userPaymentMethodRepository;

    @Override
    public List<UserPaymentMethod> getAllUserPaymentMethods() {
        return userPaymentMethodRepository.findAll();
    }

    @Override
    public int addUserPaymentMethod(UserPaymentMethod userPaymentMethod) {
        UserPaymentMethod newUserPaymentMethod = userPaymentMethodRepository.save(userPaymentMethod);
        return newUserPaymentMethod.getId();
    }

    @Transactional
    @Override
    public boolean deleteUserPaymentMethod(int userPaymentMethodId) {
        try {
            userPaymentMethodRepository.deleteById(userPaymentMethodId);
            return true; // Deletion successful
        } catch (EmptyResultDataAccessException e) {
            return false; // No user payment method with the given ID found
        }
    }

}
