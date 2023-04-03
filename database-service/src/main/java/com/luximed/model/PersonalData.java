package com.luximed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonalData {

    @Id
    @Column(unique = true, nullable = false)
    private String pesel;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private Gender gender;
}
