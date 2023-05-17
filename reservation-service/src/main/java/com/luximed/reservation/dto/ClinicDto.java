package com.luximed.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClinicDto {
    private Integer id;
    private String city;
    private String street;
    private String buildingNumber;
    private String postalCode;
}
