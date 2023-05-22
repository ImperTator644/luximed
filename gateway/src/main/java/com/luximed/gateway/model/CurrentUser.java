package com.luximed.gateway.model;

import org.springframework.stereotype.Component;

@Component
public class CurrentUser {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
