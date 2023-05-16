package com.luximed.client.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PersonalDataDto {
    private String pesel;
    private String name;
    private String surname;
    private String mail;
    private String phone;
    private Gender gender;
}
