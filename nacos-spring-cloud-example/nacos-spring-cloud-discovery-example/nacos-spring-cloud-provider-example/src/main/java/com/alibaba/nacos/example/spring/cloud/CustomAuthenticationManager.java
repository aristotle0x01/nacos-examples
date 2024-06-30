//package com.alibaba.nacos.example.spring.cloud;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//
////@Component
//public class CustomAuthenticationManager implements AuthenticationManager {
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        // Custom authentication logic
//        if ("user".equals(username) && "password".equals(password)) {
//            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
//        } else {
//            throw new BadCredentialsException("Invalid username or password");
//        }
//    }
//}