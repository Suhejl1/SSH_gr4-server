package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> getAllUsers();

    int deleteUser(int id);
}
