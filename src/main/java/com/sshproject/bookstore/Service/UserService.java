package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.User;
import com.sshproject.bookstore.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService implements UserServiceInterface{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> data = userRepository.findAll();

        return data;
    }
}
