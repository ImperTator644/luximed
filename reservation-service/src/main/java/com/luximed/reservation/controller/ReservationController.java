package com.luximed.reservation.controller;

import com.luximed.reservation.client.DatabaseClient;
import com.luximed.reservation.dto.ClinicDto;
import com.luximed.reservation.dto.DoctorDto;
import com.luximed.reservation.dto.PatientDto;
import com.luximed.reservation.dto.SpecializationDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {

    private final DatabaseClient databaseClient;

    public ReservationController(DatabaseClient databaseClient) {
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
    public List<DoctorDto> getDoctorsBySpecializationAndCity(@RequestParam String specialization, @RequestParam String city){
        return databaseClient.getDoctorsBySpecializationAndCity(specialization, city);
    }

    @GetMapping(value = "/patient/pesel/{pesel}")
    public PatientDto getPatientByPesel(@PathVariable String pesel){
        return databaseClient.getPatientByPesel(pesel);
    }

    @GetMapping(value = "/doctor/{id}")
    public DoctorDto getDoctorById(@PathVariable Integer id){
        return databaseClient.getDoctorById(id);
    }

    @GetMapping(value = "/clinic/{id}")
    public ClinicDto getClinicById(@PathVariable Integer id){
        return databaseClient.getClinicById(id);
    }


}
