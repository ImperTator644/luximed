package com.luximed.reservation.dto;

import com.luximed.reservation.model.Gender;
import lombok.Data;

@Data
public class PersonalDataDto {
    private String pesel;
    private String name;
    private String surname;
    private String mail;
    private String phone;
    private Gender gender;
}
