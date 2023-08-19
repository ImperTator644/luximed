package com.luximed.frontservice.model;

import com.luximed.frontservice.service.CurrentUserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CurrentUser {
    private String userName;

    private final CurrentUserService currentUserService;

    public CurrentUser(CurrentUserService currentUserService) {
        this.currentUserService = currentUserService;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @PostConstruct
    public void init(){
        this.userName = currentUserService.getCurrentUser();
    }
}