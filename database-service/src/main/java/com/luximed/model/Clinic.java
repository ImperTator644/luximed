package com.luximed.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String buildingNumber;

    @Column(nullable = false)
    private String postalCode;
}
