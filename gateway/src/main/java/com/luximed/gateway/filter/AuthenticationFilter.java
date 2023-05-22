package com.luximed.gateway.filter;

import com.luximed.gateway.model.CurrentUser;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request;
            request = exchange.getRequest()
                    .mutate()
                    .header("loggedInUser", CurrentUser.getInstance().getUserName())
                    .build();
            return chain.filter(exchange.mutate().request(request).build());
        });
    }

    public static class Config {

    }
}
