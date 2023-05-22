package com.luximed.gateway.service;

import com.luximed.gateway.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomUserDetailsService {
    @Autowired
    private PersonalInfoRepository databaseClient;

    public Mono<UserDetails> findByUsername(String pesel) {
        return databaseClient.findByUsername(pesel);
    }
}
