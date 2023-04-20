package com.luximed.frontservice.controller;

import com.luximed.frontservice.client.ClinicClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestClinicController {
    private final ClinicClient clinicClient;

    public TestClinicController(ClinicClient clinicClient) {
        this.clinicClient = clinicClient;
    }

    @GetMapping( "clinic")
    public String getClinicById(){
        return "clinic";
    }

    @PostMapping("clinic/add")
    public String addClinic(@RequestParam String buildingNumber,
                            @RequestParam String city,
                            @RequestParam String postalCode,
                            @RequestParam String street,
                            ModelMap model)
    {
        clinicClient.addClinic(buildingNumber,city,postalCode,street);
        model.put("greeting", "Welcome clinic");
        model.put("buildingNumber", buildingNumber);
        model.put("city", city);
        model.put("street", street);
        model.put("postalCode", postalCode);
        return "welcome-clinic";
    }

    @PostMapping("clinic/delete")
    public String addClinic(@RequestParam Integer id,
                            ModelMap model)
    {
        clinicClient.deleteClinic(id);
        model.put("id", id);
        return "nara-clinic";
    }
}