package com.luximed.frontservice.dto;

import com.luximed.frontservice.client.ClinicClient;
import lombok.Data;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Component
public class AppointmentDto {
    private Integer id;
    private PatientDto patient;
    private DoctorDto doctor;
    private ClinicDto clinic;
    private LocalDate date;
    private LocalDateTime time;
}
