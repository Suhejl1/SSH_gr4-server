package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    List<User> getAllUsers();

    int deleteUser(int id);

    Optional<User> findUserByEmail(String email);
}
