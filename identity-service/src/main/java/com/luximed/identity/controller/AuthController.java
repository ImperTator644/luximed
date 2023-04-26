package com.luximed.identity.controller;

import com.luximed.identity.dto.PersonalDataDto;
import com.luximed.identity.model.UserCredential;
import com.luximed.identity.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "register")
    public boolean addNewPatient(@RequestBody PersonalDataDto personalDataDto){
        return authService.savePatient(personalDataDto);
    }

    @GetMapping(value = "token")
    public String getToken(@RequestBody UserCredential userCredential){
        return authService.generateToken(userCredential.getPesel());
    }

    @GetMapping(value = "/validate")
    public String validateToken(@RequestParam("token") String token){
        authService.validateToken(token);
        return "Token is valid";
    }
}
