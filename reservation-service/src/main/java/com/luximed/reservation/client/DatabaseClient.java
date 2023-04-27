package com.luximed.reservation.client;

import com.luximed.reservation.dto.ClinicDto;
import com.luximed.reservation.dto.DoctorDto;
import com.luximed.reservation.dto.SpecializationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="database-service")
public interface DatabaseClient {
    @GetMapping(value="api/database/specialization/all")
    List<SpecializationDto> getAllSpecializations();

    @GetMapping(value="api/database/clinic/by-city/{city}")
    List<ClinicDto> getClinicsByCity(@PathVariable String city);

    @GetMapping(value = "api/database/doctor/by-city-and-spec")
    List<DoctorDto> getDoctorsBySpecializationAndCity(@RequestParam String specializationName, @RequestParam String city);
}
