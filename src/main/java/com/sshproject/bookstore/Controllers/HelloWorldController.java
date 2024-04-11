package com.sshproject.bookstore.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class HelloWorldController {


    @GetMapping("/")
    public String hello() {
        return "Welcome to server!";
    }
}