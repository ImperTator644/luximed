package com.luximed.gateway.filter;

import com.luximed.gateway.controller.AuthController;
import com.luximed.gateway.controller.TestController;
import com.luximed.gateway.exception.AuthorizationException;
import com.luximed.gateway.model.CurrentUser;
import com.luximed.gateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.Currency;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    private RouteValidator validator;

    @Autowired
    private TestController testController;

    private final JwtUtil jwtUtil;
    private static final String POSTMAN_PREFIX = "Bearer ";

    public AuthenticationFilter(JwtUtil jwtUtil) {
        super(Config.class);
        this.jwtUtil = jwtUtil;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = null;
            StringBuilder requestDetails = new StringBuilder();
            request = exchange.getRequest()
                    .mutate()
                    .header("loggedInUser", CurrentUser.getInstance().getUserName())
                    .build();
            return chain.filter(exchange.mutate().request(request).build());
        });
    }

    @Autowired
    public void setValidator(RouteValidator validator) {
        this.validator = validator;
    }

    public static class Config {

    }
}
