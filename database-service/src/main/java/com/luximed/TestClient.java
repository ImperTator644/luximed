package com.luximed;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("test-service")
public interface TestClient {

    @GetMapping("/test")
    String executeTest();
}
