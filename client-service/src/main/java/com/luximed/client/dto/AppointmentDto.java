package com.luximed.client.dto;

import lombok.Data;
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
    private LocalDateTime start, end;
    private String title;
    private AppointmentTypeDto appointmentType;
}
