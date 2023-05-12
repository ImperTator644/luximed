package com.luximed.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientDto {
    private Integer id;
    private PersonalDataDto personalData;
}
