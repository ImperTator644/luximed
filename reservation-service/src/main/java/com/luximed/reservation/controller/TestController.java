package com.luximed.reservation.controller;

import com.luximed.reservation.client.DatabaseClient;
import com.luximed.reservation.dto.ClinicDto;
import com.luximed.reservation.dto.DoctorDto;
import com.luximed.reservation.dto.SpecializationDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservation")
public class TestController {

    private final DatabaseClient databaseClient;

    public TestController(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @GetMapping(value = "specializations")
    public List<SpecializationDto> getAllSpecializations(){
        return databaseClient.getAllSpecializations();
    }

    @GetMapping(value = "clinics/{city}")
    public List<ClinicDto> getClinicsByCity(@PathVariable("city") String city){
        return databaseClient.getClinicsByCity(city);
    }

    @GetMapping(value = "doctors/by-city-and-spec")
    public List<DoctorDto> getDoctorsBySpecializationAndClinic(@RequestParam String specializationName, @RequestParam String city){
        return databaseClient.getDoctorsBySpecializationAndCity(specializationName, city);
    }
}
