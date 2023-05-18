package com.luximed.frontservice.controller;

import com.luximed.frontservice.client.ClinicClient;
import com.luximed.frontservice.dto.PatientDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class ClientController {
    private final ClinicClient clinicClient;

    public ClientController(ClinicClient clinicClient) {
        this.clinicClient = clinicClient;
    }

    @GetMapping("patient/all")
    @ResponseBody
    public List<PatientDto> getPatients(){
        return clinicClient.getPatients();
    }

    @GetMapping("patient")
    public String getPatient(){
        return "patient";
    }

}
