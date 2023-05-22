package com.luximed.frontservice.client;

import com.luximed.frontservice.dto.MessageDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("gateway")
public interface AuthClient {
    @GetMapping(value = "/auth/getCurrentUser")
    MessageDto getCurrentUser();
}
