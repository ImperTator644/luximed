package com.luximed.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "test-service")
public interface TestClient {

    @GetMapping("/test")
    String test();
}
