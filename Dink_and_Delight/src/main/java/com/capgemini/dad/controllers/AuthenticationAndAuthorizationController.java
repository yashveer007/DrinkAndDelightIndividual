package com.capgemini.dad.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dad.entity.AuthRequest;
import com.capgemini.dad.entity.User;
import com.capgemini.dad.services.CustomUserDetailsService;
import com.capgemini.dad.util.JwtUtil;


@RestController
public class AuthenticationAndAuthorizationController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private CustomUserDetailsService service;

    @GetMapping("/")
    public String welcome() {
        return "Authentication & Authorization Successful (-- Welcome to DRINK AND DELIGHT --)";
    }
    
    
    @PostMapping("/registration")
    public void addUser (@RequestBody User user) {
    	service.addUser(user);
    }

    
// Endpoint is enable even after spring security due to config.     
// validating username name & password & generating token. If wrong, don't proceed with exception.
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}