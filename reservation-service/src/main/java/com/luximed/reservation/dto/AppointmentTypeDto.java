package com.luximed.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppointmentTypeDto {
    private Integer id;
    private SpecializationDto specialization;
    private String name;
    private String description;
    private Integer duration;
}
