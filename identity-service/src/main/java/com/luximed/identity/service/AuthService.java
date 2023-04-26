package com.luximed.identity.service;

import com.luximed.identity.client.PersonalDataClient;
import com.luximed.identity.dto.PersonalDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PersonalDataClient personalDataClient;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public boolean savePatient(PersonalDataDto personalData) {
        personalData.setPassword(passwordEncoder.encode(personalData.getPassword()));
        personalDataClient.addPersonalData(personalData.getPesel(),
                personalData.getGender().getDescription(),
                personalData.getMail(),
                personalData.getName(),
                personalData.getSurname(),
                personalData.getPhone(),
                personalData.getPassword());
        personalDataClient.addPatient(personalData.getPesel());
        return true;
    }

    public String generateToken(String pesel){
        return jwtService.generateToken(pesel);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }
}
