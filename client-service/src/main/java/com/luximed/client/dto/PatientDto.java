package com.luximed.client.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PatientDto {
    private Integer id;
    private PersonalDataDto personalData;
}
