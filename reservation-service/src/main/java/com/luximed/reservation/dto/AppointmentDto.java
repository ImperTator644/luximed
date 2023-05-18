package com.luximed.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
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
