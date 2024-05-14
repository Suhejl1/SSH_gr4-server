package com.sshproject.bookstore.auth;

import com.sshproject.bookstore.Entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationService service;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.signup(request));
    }


    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody AuthenticationRequest request) {
        try {
            AuthenticationResponse response = service.signin(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }




}
