package com.luximed.frontservice.client;

import com.luximed.frontservice.dto.AppointmentDto;
import com.luximed.frontservice.dto.ClinicDto;
import com.luximed.frontservice.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/api/database/appointment/all")
    List<AppointmentDto> getAppointments();

    @GetMapping(value = "/api/database/patient/all")
    List<PatientDto> getPatients();

    @GetMapping(value = "/api/database/appointment/{id}")
    AppointmentDto getAppointmentById(@PathVariable Integer id);

    @GetMapping(value = "/api/database/appointment/patient/{id}")
    List<AppointmentDto> getAppointmentsByPatientId(@PathVariable Integer id);

    @PostMapping(value = "/api/database/appointment/patient")
    List<AppointmentDto> getAppointmentsByPatientIdTwo(@RequestParam Integer id);
}
