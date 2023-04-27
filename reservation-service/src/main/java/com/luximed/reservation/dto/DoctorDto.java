package com.luximed.reservation.dto;

import lombok.Data;

import java.util.List;

@Data
public class DoctorDto {
    private Integer id;
    private PersonalDataDto personalData;
    private List<SpecializationDto> specialization;
    private List<ClinicDto> clinics;
}
