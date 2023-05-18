package com.luximed.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class AppointmentDto {

    private Integer id;
    private PatientDto patient;
    private DoctorDto doctor;
    private ClinicDto clinic;
    private LocalDate date;
    private LocalTime time;
    private LocalTime start, end;
    private String title;
    private AppointmentTypeDto appointmentType;

}
