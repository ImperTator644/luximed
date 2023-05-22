package com.luximed.gateway.config;

import com.luximed.gateway.model.CurrentUser;
import com.luximed.gateway.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.authentication.logout.RedirectServerLogoutSuccessHandler;
import reactor.core.publisher.Mono;

@EnableWebFluxSecurity
@Configuration
public class AuthConfig {

    @Autowired
    private PersonalInfoRepository personalInfoRepository;

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
        return http.csrf().disable()
                .authorizeExchange()
                .pathMatchers("/auth/register", "/auth/validate").permitAll()
                .anyExchange().authenticated()
                .and()
                .formLogin()
                .authenticationSuccessHandler(new RedirectServerAuthenticationSuccessHandler("/") {
                    @Override
                    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
                        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                        CurrentUser currentUser = CurrentUser.getInstance();
                        currentUser.setUserName(userDetails.getUsername());
                        return super.onAuthenticationSuccess(webFilterExchange, authentication);
                    }
                })
                .and()
                .logout()
                .logoutSuccessHandler(new RedirectServerLogoutSuccessHandler() {
                    @Override
                    public Mono<Void> onLogoutSuccess(WebFilterExchange exchange, Authentication authentication) {
                        CurrentUser currentUser = CurrentUser.getInstance();
                        currentUser.setUserName(null);
                        return super.onLogoutSuccess(exchange, authentication);
                    }
                })
                .and()
                .build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ReactiveUserDetailsService userDetailsService() {
        return (pesel) -> personalInfoRepository.findByUsername(pesel);
    }
}
