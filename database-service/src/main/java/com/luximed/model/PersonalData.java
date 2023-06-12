package com.luximed.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@AllArgsConstructor
public class PersonalData {

    @Id
    @Column(unique = true, nullable = false)
    @NotNull(message = "Pesel is null")
    @NotBlank(message = "Pesel is blank")
    private String pesel;

    @Column(nullable = false)
    @NotNull(message = "Password is null")
    @NotBlank(message = "Password is blank")
    private String password;

    @NotNull(message = "Name is null")
    @NotBlank(message = "Name is blank")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Surname is null")
    @NotBlank(message = "Surname is blank")
    @Column(nullable = false)
    private String surname;

    @NotNull(message = "E-mail is null")
    @NotBlank(message = "E-mail is blank")
    @Email
    @Column(nullable = false)
    private String mail;

    @NotNull(message = "Phone is null")
    @NotBlank(message = "Phone is blank")
    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public PersonalData() {

    }
}
