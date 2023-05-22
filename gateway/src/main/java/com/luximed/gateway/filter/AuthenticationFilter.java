package com.luximed.gateway.filter;

import com.luximed.gateway.model.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
    @Autowired
    private CurrentUser currentUser;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request;
            request = exchange.getRequest()
                    .mutate()
                    .header("loggedInUser", currentUser.getUserName())
                    .build();
            return chain.filter(exchange.mutate().request(request).build());
        });
    }

    public static class Config {

    }
}
