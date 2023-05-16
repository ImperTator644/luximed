package com.luximed.identity.service;

import com.luximed.identity.client.DatabaseClient;
import com.luximed.identity.config.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private DatabaseClient databaseClient;

    @Override
    public UserDetails loadUserByUsername(String pesel) throws UsernameNotFoundException {
        return new CustomUserDetails(databaseClient.getUserCredentialsByPesel(pesel));
    }
}
