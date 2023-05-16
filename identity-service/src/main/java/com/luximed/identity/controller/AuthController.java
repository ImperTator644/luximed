package com.luximed.identity.controller;

import com.luximed.identity.dto.PersonalDataDto;
import com.luximed.identity.exception.IdentityException;
import com.luximed.identity.model.UserCredential;
import com.luximed.identity.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(value = "register")
    public boolean addNewPatient(@RequestBody PersonalDataDto personalDataDto) {
        return authService.savePatient(personalDataDto);
    }

    @PostMapping(value = "token")
    public String getToken(@RequestBody UserCredential userCredential) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredential.getPesel(), userCredential.getPassword()));
        if (authentication.isAuthenticated()) {
            return authService.generateToken(userCredential.getPesel());
        } else {
            throw new IdentityException("Invalid access");
        }
    }

    @GetMapping(value = "validate")
    public String validateToken(@RequestParam("token") String token) {
        authService.validateToken(token);
        return "Token is valid";
    }
}
