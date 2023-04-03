package com.luximed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    TestClient testClient;

    @GetMapping("/database")
    public String getTestInfo() {
        return testClient.executeTest();
    }
}
