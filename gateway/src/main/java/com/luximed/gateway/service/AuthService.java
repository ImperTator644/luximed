package com.luximed.gateway.service;

import com.luximed.gateway.client.DatabaseClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final DatabaseClient databaseClient;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

//    public boolean savePatient(PersonalDataDto personalData) {
//        personalData.setPassword(passwordEncoder.encode(personalData.getPassword()));
//        databaseClient.addPersonalData(personalData.getPesel(),
//                personalData.getGender(),
//                personalData.getMail(),
//                personalData.getName(),
//                personalData.getSurname(),
//                personalData.getPhone(),
//                personalData.getPassword());
//        databaseClient.addPatient(personalData.getPesel());
//        return true;
//    }

    public String generateToken(String pesel){
        return jwtService.generateToken(pesel);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }
}
