package com.sshproject.bookstore.auth;

import com.sshproject.bookstore.Entity.Role;
import com.sshproject.bookstore.Entity.User;
import com.sshproject.bookstore.Repository.RoleRepository;
import com.sshproject.bookstore.Repository.UserRepository;
import com.sshproject.bookstore.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final RoleRepository roleRepository;


    public com.sshproject.bookstore.Entity.User signup(RegisterRequest registerRequest){
        if(repository.findByEmailAddress(registerRequest.getEmail()).isPresent()){
            throw new IllegalArgumentException("Email argument already exists");
        }

        Role role = roleRepository.findByName("USER");
        com.sshproject.bookstore.Entity.User user =  new User();
        user.setEmailAddress(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(role);

        return repository.save(user);
    }

    public AuthenticationResponse signin(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmailAddress(request.getEmail()).orElseThrow(()-> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(new HashMap<>(),user);
//        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(),user);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwt);
//        authenticationResponse.setRefreshToken(refreshToken);
        return authenticationResponse;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmailAddress(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
