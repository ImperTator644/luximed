package com.luximed.client.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class DoctorDto {
    private Integer id;
    private PersonalDataDto personalData;
    private List<SpecjalizationDto> specjalization;
}
