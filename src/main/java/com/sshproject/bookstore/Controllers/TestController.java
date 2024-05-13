package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.User;
import com.sshproject.bookstore.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/roleid")
    public int getRoleId(){
//        Optional<User> user =  userRepository.findByEmailAddress(email);
//        int roleId = 0;
//        if (user.isPresent()){
//            roleId = user.get().getRole().getId();
//            return roleId;
//        }
//        return -1;
        return 100;
    }

}
