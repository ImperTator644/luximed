package com.luximed.identity.client;

import com.luximed.identity.model.UserCredential;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "database-service")
public interface DatabaseClient {

    @GetMapping(value = "api/database/personalData/{pesel}")
    UserCredential getUserCredentialsByPesel(@PathVariable String pesel);

    @PostMapping(value = "api/database/personalData/add")
    void addPersonalData(@RequestParam String pesel,
                         @RequestParam Integer gender,
                         @RequestParam String mail,
                         @RequestParam String name,
                         @RequestParam String surname,
                         @RequestParam String phone,
                         @RequestParam String password);

    @PostMapping(value = "api/database/patient/add")
    void addPatient(@RequestParam String pesel);
}
