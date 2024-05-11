package com.sshproject.bookstore.config;

import com.sshproject.bookstore.Entity.User;
import com.sshproject.bookstore.Repository.UserRepository;
import com.sshproject.bookstore.Service.AuthorizationExtracterService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {
    private final AuthorizationExtracterService authorizationExtracterService;
    private final JwtService jwtService;

    private final UserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String method = request.getMethod();
        System.out.println(method);
        String endpoint = request.getRequestURI();
        System.out.println(endpoint);
        String verb = "all";

        //Get auth header which contains the jwt token
        final String authHeader  = request.getHeader("Authorization");
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        String jwt = authHeader.substring(7);
        String email = jwtService.extractUsername(jwt);


       Optional<User> user =  userRepository.findByEmailAddress(email);
       int roleId = 0;
       if (user.isPresent()){
           roleId = user.get().getRole().getId();
       }

       boolean isAuthorized = checkAuthorization(method,endpoint,verb,roleId);


        if (isAuthorized) {
            filterChain.doFilter(request, response); // Allow the request to proceed
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Return unauthorized status
        }

    }


    private boolean checkAuthorization(String method, String endpoint, String verb, int current_role_id){
        int abilityId = authorizationExtracterService.getAbilityIdFromHTTPREquest(method,endpoint,verb);
        List<Integer> roleIds = authorizationExtracterService.getRoleIdFromAbilityId(abilityId);
        for(int i: roleIds){
            System.out.println("Role Id number: " + i);
            if (current_role_id==i){
                System.out.println("Not authorized");
                return false;
            }
        }
        return true;
    }
}
