package com.luximed.model;

import javax.persistence.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(nullable = false)
    private PersonalData personalData;
}
