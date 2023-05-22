package com.luximed.gateway.controller;

import com.luximed.gateway.model.UserCredential;
import com.luximed.gateway.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

//    @PostMapping(value = "register")
//    public boolean addNewPatient(@RequestBody PersonalDataDto personalDataDto) {
//        return authService.savePatient(personalDataDto);
//    }

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
