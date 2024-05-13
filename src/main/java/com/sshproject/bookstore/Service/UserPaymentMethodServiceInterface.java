package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.UserPaymentMethod;

import java.util.List;

public interface UserPaymentMethodServiceInterface {
    List<UserPaymentMethod> getAllUserPaymentMethods();

    int addUserPaymentMethod(UserPaymentMethod userPaymentMethod);

    boolean deleteUserPaymentMethod(int userPaymentMethodId);
}
