package com.luximed.gateway.controller;

import com.luximed.gateway.model.CustomUserDetails;
import com.luximed.gateway.model.UserCredential;
import com.luximed.gateway.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "auth/register")
    public boolean addNewPatient(@RequestBody CustomUserDetails userDetails) {
        return authService.savePatient(userDetails);
    }

    @PostMapping(value = "login")
    public String getToken(UserCredential userCredential) {
        return authService.generateToken(userCredential.getUsername());
    }

    @GetMapping(value = "validate")
    public String validateToken(@RequestParam("token") String token) {
        authService.validateToken(token);
        return "Token is valid";
    }
}
