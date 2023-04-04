package com.luximed.frontservice.client;

import com.luximed.frontservice.dto.ClinicDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "database-service")
public interface ClinicClient {
    @GetMapping(value = "/api/database/get-clinic")
    ClinicDto getClinicById(@RequestParam("id") Integer id);

    @PostMapping(value = "/api/database/add-clinic")
    void addClinic(@RequestParam String buildingNumber,
                   @RequestParam String city,
                   @RequestParam String postalCode,
                   @RequestParam String street);

    @PostMapping(value = "/api/database/delete-clinic")
    void deleteClinic(@RequestParam Integer id);
}
