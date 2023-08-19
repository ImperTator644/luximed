package com.luximed.frontservice.config;

import com.luximed.frontservice.model.CurrentUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("thymeleaf")
public class ThymeleafIncludeConfig {
    @Value("${log.current.empty.user}")
    private String emptyUser;
    private final CurrentUser currentUser;

    public ThymeleafIncludeConfig(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    public String getCurrentUserPesel(){
        return currentUser.getUserName();
    }
    public String getEmptyUser(){
        return emptyUser;
    }
}
