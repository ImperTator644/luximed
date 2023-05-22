package com.luximed.gateway.controller;

import com.luximed.gateway.model.CurrentUser;
import com.luximed.gateway.repository.PersonalInfoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final PersonalInfoRepository databaseClient;

    public TestController(PersonalInfoRepository databaseClient) {
        this.databaseClient = databaseClient;
    }

    @GetMapping(value = "/auth/getCurrentUser")
    public String test(){
        return CurrentUser.getInstance().getUserName();
    }
}
