package com.luximed.test;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
public class DatabaseController {
    private final TestClient testClient;

    public DatabaseController(TestClient testClient) {
        this.testClient = testClient;
    }

    @GetMapping("/database")
    public String getTestInfo() {
        return testClient.test();
    }
}
