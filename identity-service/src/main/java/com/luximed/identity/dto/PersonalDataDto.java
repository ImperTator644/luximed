package com.luximed.identity.dto;

import lombok.Data;

@Data
public class PersonalDataDto {
    private String pesel;
    private String password;
    private String name;
    private String surname;
    private String mail;
    private String phone;
    private Integer gender;
}
